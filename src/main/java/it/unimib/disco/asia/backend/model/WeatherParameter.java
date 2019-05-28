package it.unimib.disco.asia.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherParameter {

    private String id;
    private Double minValue;
    private Double maxValue;
    private Double avgValue;
    private Double cumulValue;

    public WeatherParameter(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Double getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(Double avgValue) {
        this.avgValue = avgValue;
    }

    public Double getCumulValue() {
        return cumulValue;
    }

    public void setCumulValue(Double cumulValue) {
        this.cumulValue = cumulValue;
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
