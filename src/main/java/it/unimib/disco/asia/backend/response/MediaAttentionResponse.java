package it.unimib.disco.asia.backend.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaAttentionResponse {

    private List<Map<String, Double>> data;

    private String category;

}
