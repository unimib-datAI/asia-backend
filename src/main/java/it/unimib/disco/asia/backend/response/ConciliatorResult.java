package it.unimib.disco.asia.backend.response;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConciliatorResult {

	private String conciliator;
	private Result[] result;
	
	public Result[] getResult() {
		return result;
	}
	public void setResult(Result[] result) {
		this.result = result;
	}
	public String getConciliator() {
		return conciliator;
	}
	public void setConciliator(String conciliator) {
		this.conciliator = conciliator;
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
