package it.unimib.disco.asia.backend.response;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Conciliator {

    private String id;
    private String name;
    private String identifierSpace;
    private String schemaSpace;

    public Conciliator(String id) {
        this.id = id;
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

    public String getIdentifierSpace() {
        return identifierSpace;
    }

    public void setIdentifierSpace(String identifierSpace) {
        this.identifierSpace = identifierSpace;
    }

    public String getSchemaSpace() {
        return schemaSpace;
    }

    public void setSchemaSpace(String schemaSpace) {
        this.schemaSpace = schemaSpace;
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
