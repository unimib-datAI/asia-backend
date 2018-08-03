package it.unimib.disco.asia.backend.model;

import java.util.Map;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

@Document("vincenzo")
public class Vincenzo {

	@Id
	private String geonamesId;

	private String validTime;
	private String validityDateTime;
	private Map<String, String> params;
	public String getGeonamesId() {
		return geonamesId;
	}
	public void setGeonamesId(String geonamesId) {
		this.geonamesId = geonamesId;
	}
	public String getValidTime() {
		return validTime;
	}
	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}
	public String getValidityDateTime() {
		return validityDateTime;
	}
	public void setValidityDateTime(String validityDateTime) {
		this.validityDateTime = validityDateTime;
	}
	public Map<String, String> getParams() {
		return params;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String out = "";
		try { 
			out = mapper.writeValueAsString(this);
		}catch(Exception e) { e.printStackTrace();}
		
		return out;
	}
}


