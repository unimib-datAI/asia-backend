package it.unimib.disco.asia.backend.model;

import com.arangodb.springframework.annotation.Field;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaAttentionQuery {

    @JsonProperty("$from")
    @Field("$from")
    private String from;

    @JsonProperty("EventFeatureId")
    @Field("EventFeatureId")
    private String eventFeatureId;

    @JsonIgnore
    private String category;

}
