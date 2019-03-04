package it.unimib.disco.asia.backend.model;

import com.arangodb.springframework.annotation.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

@Document("event")
public class Event {

    private String geonamesId;
    private String eventDate;
    private String[] categories;
    private int eventsCount;

    public String getGeonamesId() {
        return geonamesId;
    }

    public void setGeonamesId(String geonamesId) {
        this.geonamesId = geonamesId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public int getEventsCount() {
        return eventsCount;
    }

    public void setEventsCount(int eventsCount) {
        this.eventsCount = eventsCount;
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


