package it.unimib.disco.asia.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "virtuoso")
public class VirtuosoConfig {
    private String endpoint;
    private String graphName;
    private String matchPropertyPrefix;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getGraphName() {
        return graphName;
    }

    public void setGraphName(String graphName) {
        this.graphName = graphName;
    }

    public String getMatchPropertyPrefix() {
        return matchPropertyPrefix;
    }

    public void setMatchPropertyPrefix(String matchPropertyPrefix) {
        this.matchPropertyPrefix = matchPropertyPrefix;
    }
}
