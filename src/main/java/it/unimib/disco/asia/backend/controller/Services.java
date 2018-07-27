package it.unimib.disco.asia.backend.controller;

import it.unimib.disco.asia.backend.response.Conciliator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Services {

    private static final Map<String, Conciliator[]> services = new HashMap<>();
    static {
        Conciliator[] general = {
                new Conciliator("wikifier", "Wikifier")
        };
        Conciliator[] geo = {
                new Conciliator("geonames", "GeoNames"),
                new Conciliator("geotargets", "Google Geotargets")
        };
        Conciliator[] category = {
                new Conciliator("productsservices", "Google ProductsServices")
        };

        services.put("general", general);
        services.put("geo", geo);
        services.put("category", category);
    }

	@RequestMapping(value = "services", produces = "application/json")
	public static Map<String, Conciliator[]> services() {
		return services;
	}

}
