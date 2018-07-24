package it.unimib.disco.asia.backend.requestResult;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
	private QueryResult q0;

	public QueryResult getQ0() {
		return q0;
	}
	public void setQ0(QueryResult q0) {
		this.q0 = q0;
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
