package it.unimib.disco.asia.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class Services {

	@RequestMapping(value = "services", produces = "application/json")
	public String services() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = mapper.createObjectNode();
		ObjectNode services = mapper.createObjectNode();

		
		ArrayNode general = mapper.createArrayNode();
		ObjectNode wikifier = mapper.createObjectNode();
		wikifier.put("name", "wikifier");
		wikifier.put("id", "wikifier");
		general.add(wikifier);
		services.set("general", general);

		ArrayNode geo = mapper.createArrayNode();
		ObjectNode geonames = mapper.createObjectNode();
		geonames.put("name", "geonames");
		geonames.put("id", "geonames");
		geo.add(geonames);
		ObjectNode geotarget = mapper.createObjectNode();
		geotarget.put("name", "Google geotarget");
		geotarget.put("id", "geotarget");
		geo.add(geotarget);
		services.set("geo", geo);
		
		ArrayNode category = mapper.createArrayNode();
		ObjectNode productsservices = mapper.createObjectNode();
		productsservices.put("name", "Google productsservices");
		productsservices.put("id", "productsservices");
		category.add(productsservices);
		services.set("category", category);
		
		root.set("services", services);
		
		return root.toString();
	}
}
