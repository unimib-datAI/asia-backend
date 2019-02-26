package it.unimib.disco.asia.backend.model;

/**
 * Enumerate all services exposed by the Conciliator
 * TODO: the conciliator should expose a /list method to retrieve all the identifiers
 */
public enum Service {
    WIKIFIER("wikifier"),
    GEONAMES("geonames"),
    GEOTARGETS("geotargets"),
    GOOGLECAT("productsservices");

    private String id;

    Service(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
