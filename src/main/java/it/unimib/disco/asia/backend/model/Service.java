package it.unimib.disco.asia.backend.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enumerate all services exposed by the Conciliator
 */
public enum Service {
    WIKIFIER("wikifier"),
    GEONAMES("geonames"),
    GEOTARGETS("geotargets"),
    CATEGORYFIND("keywordsmatcher"),
    GOOGLECAT("productsservices");

    private String id;

    Service(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public static List<String> serviceList() {
        return Stream.of(Service.values())
                .map(Service::name)
                .collect(Collectors.toList());
    }

}
