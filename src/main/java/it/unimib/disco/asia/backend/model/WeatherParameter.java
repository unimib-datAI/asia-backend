package it.unimib.disco.asia.backend.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherParameter {

    private String id;
    private String value;

    public WeatherParameter(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
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
