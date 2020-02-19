package it.unimib.disco.asia.backend.connectors;

import it.unimib.disco.asia.backend.config.MediaAttentionConfig;
import it.unimib.disco.asia.backend.model.MediaAttentionInterRequest;
import it.unimib.disco.asia.backend.response.MediaAttentionResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Lazy
public class MediaAttentionConnector {

    final RestTemplate restTemplate = new RestTemplate();
    private final String url;

    public MediaAttentionConnector(MediaAttentionConfig serviceConfig) {
        url = serviceConfig.getBaseURI() + "/enrich";
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public MediaAttentionResponse getMediaAttentionResponse(MediaAttentionInterRequest request) {

        try {
            return restTemplate
                    .postForObject(url, request, MediaAttentionResponse.class);

        } catch (Exception e) {
            return new MediaAttentionResponse();
        }
    }
}

