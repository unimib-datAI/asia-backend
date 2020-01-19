package it.unimib.disco.asia.backend.connectors;


import it.unimib.disco.asia.backend.config.KeywordClusterConfig;
import it.unimib.disco.asia.backend.model.KeywordCategories;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
@Lazy
public class Key2ClusterConnector {


    final RestTemplate restTemplate = new RestTemplate();
    private final UriComponentsBuilder builder;
    private final String url;

    public Key2ClusterConnector(KeywordClusterConfig serviceConfig) {
        url = serviceConfig.getBaseURI() + "/key2cluster/api/keywords";
        builder = UriComponentsBuilder.fromUriString(url);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public List<KeywordCategories> getCategoriesForMultiKeywords(String lstStrings) {

        UriComponents urlComponents = builder.queryParam("kws", lstStrings).build();

        ResponseEntity<KeywordCategories[]> res = restTemplate.getForEntity(
                urlComponents.toUri(),
                KeywordCategories[].class);

        return Arrays.asList(res.getBody());

    }
}
