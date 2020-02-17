package it.unimib.disco.asia.backend.model.customevent;

import java.util.List;

public class CustomEventLogicRequest {
    private List<String> key;
    private List<CustomEventLogicBaseUnit> filters;

    public CustomEventLogicRequest() {
    }

    public CustomEventLogicRequest(List<String> key, List<CustomEventLogicBaseUnit> filters) {
        this.key = key;
        this.filters = filters;
    }

    public List<String> getKey() {
        return key;
    }

    public void setKey(List<String> key) {
        this.key = key;
    }

    public List<CustomEventLogicBaseUnit> getFilters() {
        return filters;
    }

    public void setFilters(List<CustomEventLogicBaseUnit> filters) {
        this.filters = filters;
    }


}
