package it.unimib.disco.asia.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.disco.asia.backend.config.ConciliatorConfig;
import it.unimib.disco.asia.backend.response.Conciliator;
import it.unimib.disco.asia.backend.response.ConciliatorResult;
import it.unimib.disco.asia.backend.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.net.URLEncoder;
import java.util.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Master {

	@Autowired
	ConciliatorConfig conciliatorConfig;

	@Autowired
	Services services;

	private Map<String, List<ConciliatorResult>> map = new HashMap<>();


	@RequestMapping(value = "reconcile", produces = "application/json")
	public String reconcile ( @RequestParam (value = "queries") String queries,
			@RequestParam (value = "conciliator") String conciliator ) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new URL(conciliatorConfig.getEndpoint() + conciliator + "?queries=" + URLEncoder.encode(queries, "UTF-8")));

		return root.toString();
	}

	@RequestMapping(value = "extend", produces = "application/json")
	public String extend ( @RequestParam (value = "extend") String extend,
							  @RequestParam (value = "conciliator") String conciliator ) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new URL(conciliatorConfig.getEndpoint() + conciliator + "?extend=" + URLEncoder.encode(extend, "UTF-8")));

		return root.toString();
	}


	@RequestMapping(value = "suggest", produces = "application/json")
	public  Map<String, List<ConciliatorResult>> suggest ( @RequestParam (value = "queries") String queries,
			@RequestParam (value = "group") String group ) throws Exception {
		
		map.clear();

		for( Conciliator conciliator : services.services().get(group)) {
			query(queries, conciliator.getId());
		}

		return map;
	}


	private void query(String queries, String conciliator) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new URL(conciliatorConfig.getEndpoint() + conciliator + "?queries=" + URLEncoder.encode(queries, "UTF-8")));
		Iterator<String> it = root.fieldNames();

		while(it.hasNext()) {
			String q = it.next();
			Result[] list = mapper.readValue(root.get(q).get("result").toString(), Result[].class);

			ConciliatorResult conciliatorResult = new ConciliatorResult();
			conciliatorResult.setConciliator(conciliator);
			conciliatorResult.setResult(list);

			List<ConciliatorResult> value = new ArrayList<>();
			if (map.containsKey(q))
				value = map.get(q);
			value.add(conciliatorResult);

			map.put(q, value);	
		}
	}

}
