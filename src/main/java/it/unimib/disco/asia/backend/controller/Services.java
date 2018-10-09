package it.unimib.disco.asia.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.disco.asia.backend.config.ConciliatorConfig;
import it.unimib.disco.asia.backend.response.Conciliator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Configuration
public class Services {

    @Autowired
    ConciliatorConfig conciliatorConfig;

    private static final Map<String, Conciliator[]> services = new HashMap<>();
    static {
        Conciliator[] general = {
                new Conciliator("wikifier")
        };
        Conciliator[] geo = {
                new Conciliator("geonames"),
                new Conciliator("geotargets")
        };
        Conciliator[] category = {
                new Conciliator("productsservices")
        };

        services.put("general", general);
        services.put("geo", geo);
        services.put("category", category);
    }

	@RequestMapping(value = "services", produces = "application/json")
	public Map<String, Conciliator[]> services() throws IOException {

        for (Map.Entry<String, Conciliator[]> entry : services.entrySet()) {
            for (Conciliator c: entry.getValue()) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(new URL(conciliatorConfig.getEndpoint() + c.getId()));

                c.setName(root.get("name").asText());
                c.setIdentifierSpace(root.get("identifierSpace").asText());
                c.setSchemaSpace(root.get("schemaSpace").asText());
            }
        }

        return services;
	}

}
