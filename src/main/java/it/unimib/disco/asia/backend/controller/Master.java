package it.unimib.disco.asia.backend.controller;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.unimib.disco.asia.backend.response.ConciliatorResult;
import it.unimib.disco.asia.backend.response.Result;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Master {

	private static final String[] allowedConciliators = {"orcid", "openlibrary", "viaf", "wikifier", "geonames", "geotargets", "productsservices"};
	private static final String baseUrl = "http://localhost:8080/reconcile/";
	private Map<String, List<ConciliatorResult>> map = new HashMap<String, List<ConciliatorResult>>();


	@RequestMapping(value = "reconcile", produces = "application/json")
	public String master0 ( @RequestParam (value = "queries") String queries,
			@RequestParam (value = "conciliator") String conciliator ) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new URL(baseUrl + conciliator + "?queries=" + URLEncoder.encode(queries, "UTF-8")));

		return root.toString();
	}


	@RequestMapping(value = "multireconcile", produces = "application/json")
	public  Map<String, List<ConciliatorResult>> master ( @RequestParam (value = "queries") String queries,
			@RequestParam (value = "conciliators", required = false) String conciliators ) throws Exception {
		
		map.clear();
		
		if(conciliators != null) {
			for( String conciliator : conciliators.split(","))
				if(Arrays.asList(allowedConciliators).contains(conciliator))
					query(queries, conciliator);
		}
		else {
			for( String conciliator : allowedConciliators)
				query(queries, conciliator);
		}

		return map;
	}


	private void query(String queries, String conciliator) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new URL(baseUrl + conciliator + "?queries=" + URLEncoder.encode(queries, "UTF-8")));
		Iterator<String> it = root.fieldNames();

		while(it.hasNext()) {
			String q = it.next();
			Result[] list = mapper.readValue(root.get(q).get("result").toString(), Result[].class);

			ConciliatorResult conciliatorResult = new ConciliatorResult();
			conciliatorResult.setConciliator(conciliator);
			conciliatorResult.setResult(list);

			List<ConciliatorResult> value = new ArrayList<ConciliatorResult>();
			if (map.containsKey(q))
				value = map.get(q);
			value.add(conciliatorResult);

			map.put(q, value);	
		}
	}

}
