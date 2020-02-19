package it.unimib.disco.asia.backend.connectors;


import it.unimib.disco.asia.backend.config.KeywordClusterConfig;
import it.unimib.disco.asia.backend.model.KeywordCategories;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Lazy
public class Key2ClusterConnector {


    final RestTemplate restTemplate = new RestTemplate();
    private final String url;

    public Key2ClusterConnector(KeywordClusterConfig serviceConfig) {
        url = serviceConfig.getBaseURI() + "/key2cluster/api/keywords?kws={keywords}";
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    public List<KeywordCategories> getCategoriesForMultiKeywords(String lstStrings) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("keywords", lstStrings);
        ResponseEntity<KeywordCategories[]> res = restTemplate.getForEntity(
                url,
                KeywordCategories[].class,
                uriVariables);
        return Arrays.asList(res.getBody());
    }
}
