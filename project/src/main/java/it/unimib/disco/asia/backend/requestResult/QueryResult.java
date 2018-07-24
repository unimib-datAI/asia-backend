package it.unimib.disco.asia.backend.requestResult;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResult {
	private Result[] result;

	public Result[] getResult() {
		return result;
	}
	public void setResult(Result[] result) {
		this.result = result;
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
