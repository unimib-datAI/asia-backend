package it.unimib.disco.asia.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaAttentionInterRequest {
    private int forecast_offset;

    private List<String> features;

    private List<String> dates;

    private MediaAttentionQuery search_query;
}
