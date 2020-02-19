package it.unimib.disco.asia.backend.controller;

import com.github.sisyphsu.dateparser.DateParserUtils;
import it.unimib.disco.asia.backend.connectors.MediaAttentionConnector;
import it.unimib.disco.asia.backend.model.MediaAttentionQuery;
import it.unimib.disco.asia.backend.model.MediaAttentionRequest;
import it.unimib.disco.asia.backend.response.MediaAttentionResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.*;
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

        formatDates(request);


        List<MediaAttentionQuery> queries = request.getCategories().stream().map(c -> mapToFeatureID(c)).collect(Collectors.toList());


        List<MediaAttentionResponse> responseList = new LinkedList<>();
        for (MediaAttentionQuery query : queries) {
            MediaAttentionResponse res = connector.getMediaAttentionResponse(request.toInterRequest(query));
            res.setCategory(query.getCategory());
            responseList.add(res);
        }

        return responseList;

    }

    private void formatDates(MediaAttentionRequest request) {
        String startDate = request.getDates().get(0);
        String endDate = request.getDates().get(1);

        List<String> formattedDates = new ArrayList<>();
        String date1 = DateParserUtils.parseDateTime(startDate).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String date2 = DateParserUtils.parseDateTime(endDate).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        formattedDates.add(date1);
        formattedDates.add(date2);
        request.setDates(formattedDates);
    }

    private MediaAttentionQuery mapToFeatureID(String c) {
        return new MediaAttentionQuery("EventsFeatures", conversionMap.getOrDefault(c, "null"), c);
    }


}
