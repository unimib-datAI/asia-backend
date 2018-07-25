package it.unimib.disco.asia.backend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.unimib.disco.asia.backend.Query;
import it.unimib.disco.asia.backend.requestResult.Response;
import it.unimib.disco.asia.backend.requestResult.Result;
import it.unimib.disco.asia.backend.response.ConciliatorResult;
import it.unimib.disco.asia.backend.response.QueryConciliatorsResult;
import it.unimib.disco.asia.backend.response.MasterResponse;

@RestController
public class Master {
	
	private static final String[] allowedConciliators = {"orcid", "openlibrary", "viaf", "wikifier", "geonames", "geotargets", "productsservices"};
	private static final String baseUrl = "http://localhost/reconcile/";


	
	@RequestMapping(value = "reconcile/master", produces = "application/json")
	public String master ( @RequestParam (value = "queries") String queries,
						   @RequestParam (value = "conciliators", required = false) String conciliators ) throws Exception {
		
		QueryConciliatorsResult[] queriesResults = null;
		List<Query> queryList =  new ArrayList<Query>();
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.readValue(queries, ObjectNode.class);
		Iterator<String> it = node.fieldNames();
		
		while(it.hasNext()) {
			JsonNode qJSON = node.get(it.next());
			Query query = mapper.readValue(qJSON.toString(), Query.class);
			queryList.add(query);
		}
		
		if(conciliators == null)   // => all conciliators
			queriesResults = func(queryList, allowedConciliators);
		else 
			queriesResults = func(queryList, conciliators.split(","));
		
		MasterResponse master = new MasterResponse();
		master.setQuery(queriesResults);
		return master.toString();
	}
	
	
	private QueryConciliatorsResult[] func(List<Query> queryList,  String[] conciliators) {
		QueryConciliatorsResult[] queriesResults = null;
		ConciliatorResult[] concResults = null; 
	
		for(Query query : queryList) {
			concResults = null;
			for(String conciliator : conciliators) {
				if(Arrays.asList(allowedConciliators).contains(conciliator)) {
					Response response = request(conciliator, query.getQuery(), query.getType(), query.getLimit());
					Result[] result = response.getQ0().getResult();
					if(result.length != 0) {
						ConciliatorResult concResult = new ConciliatorResult();
						concResult.setConciliator(conciliator);
						concResult.setResult(result);
						concResults = (ConciliatorResult[])ArrayUtils.addAll(concResults, concResult);	
					}
				}
			}
			
			QueryConciliatorsResult queryResults = new QueryConciliatorsResult();
			queryResults.setConciliatorResults(concResults);
			queriesResults = (QueryConciliatorsResult[])ArrayUtils.addAll(queriesResults, queryResults);
		}
		
		return queriesResults;
	}
	
	
	private Response request(String conciliator, String query, String type, int limit) {
		String queries = "{\"q0\":{\"query\":\"" + query + "\", \"limit\":\""+ limit +"\"";
		if(type != null) {
			queries += ", \"type\":\"" + type + "\"";
		}
		queries += "}}";
		
		RestTemplate restTemplate = new RestTemplate();
		Response response = restTemplate.getForObject(baseUrl + conciliator + "?queries={queries}", Response.class, queries);
		
		return response;
	}
}
