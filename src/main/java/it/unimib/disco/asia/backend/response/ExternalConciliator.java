package it.unimib.disco.asia.backend.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExternalConciliator extends Conciliator {

    @JsonIgnore
    private String endpoint;

    public ExternalConciliator(String id, String endpoint) {
        super(id);
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String toString() {
        return super.toString();
    }
}
