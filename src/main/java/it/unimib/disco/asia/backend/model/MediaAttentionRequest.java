package it.unimib.disco.asia.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaAttentionRequest {
    private int forecast_offset;

    private List<String> features;

    private List<String> categories;

    private List<String> dates;

    public MediaAttentionInterRequest toInterRequest(MediaAttentionQuery query) {
        MediaAttentionInterRequest request = new MediaAttentionInterRequest();
        request.setFeatures(this.features);
        request.setDates(this.dates);
        request.setForecast_offset(this.forecast_offset);
        request.setSearch_query(query);
        return request;
    }


}
