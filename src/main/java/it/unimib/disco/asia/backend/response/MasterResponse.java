package it.unimib.disco.asia.backend.response;

import com.fasterxml.jackson.databind.ObjectMapper;


public class MasterResponse {
	
	private QueryConciliatorsResult[] query;

	
	public QueryConciliatorsResult[] getQuery() {
		return query;
	}


	public void setQuery(QueryConciliatorsResult[] query) {
		this.query = query;
	}


	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String out = "";
		try { 
			out = mapper.writeValueAsString(this);
		}catch(Exception e) { e.printStackTrace();}
		
		return out;
    }
	
}
