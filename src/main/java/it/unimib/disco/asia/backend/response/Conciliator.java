package it.unimib.disco.asia.backend.response;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Conciliator {

    private String id;
    private String name;

    public Conciliator(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String out = "";
        try {
            out = mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out;
    }
}
