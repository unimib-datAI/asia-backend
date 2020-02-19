package it.unimib.disco.asia.backend.controller;

import it.unimib.disco.asia.backend.connectors.MediaAttentionConnector;
import it.unimib.disco.asia.backend.model.MediaAttentionQuery;
import it.unimib.disco.asia.backend.model.MediaAttentionRequest;
import it.unimib.disco.asia.backend.response.MediaAttentionResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class MediaAttention {

    private final MediaAttentionConnector connector;

    Map<String, String> conversionMap = new HashMap<>();

    public MediaAttention(MediaAttentionConnector connector) {
        conversionMap.put("football", "FootballGermany");
        conversionMap.put("music", "MusicGermany");

        this.connector = connector;
    }

    @PostMapping(value = "mediaattention/enrich", produces = "application/json")
    public List<MediaAttentionResponse> postMediaAttentionRequest(@RequestBody MediaAttentionRequest request) {

        List<MediaAttentionQuery> queries = request.getCategories().stream().map(c -> mapToFeatureID(c)).collect(Collectors.toList());


        List<MediaAttentionResponse> responseList = new LinkedList<>();
        for (MediaAttentionQuery query : queries) {
            MediaAttentionResponse res = connector.getMediaAttentionResponse(request.toInterRequest(query));
            res.setCategory(query.getCategory());
            responseList.add(res);
        }

        return responseList;

    }

    private MediaAttentionQuery mapToFeatureID(String c) {
        return new MediaAttentionQuery("EventsFeatures", conversionMap.getOrDefault(c, "null"), c);
    }


}
