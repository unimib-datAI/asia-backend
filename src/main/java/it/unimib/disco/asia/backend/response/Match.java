package it.unimib.disco.asia.backend.response;

public class Match {

    private String id;
    private String name;

    public Match(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Match(String id) {
       this(id, id);
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
}
