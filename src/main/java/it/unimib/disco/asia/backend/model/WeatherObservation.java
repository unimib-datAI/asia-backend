package it.unimib.disco.asia.backend.model;

import com.arangodb.springframework.annotation.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

@Document("weather-observation")
public class WeatherObservation {

    private String geonamesId;

    private String date;
    private WeatherParameter[] weatherParameters;
    private int offset;

    public String getGeonamesId() {
        return geonamesId;
    }

    public void setGeonamesId(String geonamesId) {
        this.geonamesId = geonamesId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherParameter[] getWeatherParameters() {
        return weatherParameters;
    }

    public void setWeatherParameters(WeatherParameter[] weatherParameters) {
        this.weatherParameters = weatherParameters;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
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


