package it.unimib.disco.asia.backend.response;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QueryConciliatorsResult {
	private ConciliatorResult[] conciliatorResults;

	
    public ConciliatorResult[] getConciliatorResults() {
		return conciliatorResults;
	}


	public void setConciliatorResults(ConciliatorResult[] conciliatorResults) {
		this.conciliatorResults = conciliatorResults;
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
