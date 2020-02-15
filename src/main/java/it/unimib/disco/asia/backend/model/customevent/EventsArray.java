package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Array of events extendend with json-ld context
 */
@ApiModel(description = "Array of events extendend with json-ld context")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class EventsArray {

    @JsonProperty("eventArray")
    @Valid
    private List<CustomEvent> customEventArray = null;

    /**
     * Get _atContext
     *
     * @return _atContext
     **/
    @ApiModelProperty(value = "")

    public EventsArray eventArray(List<CustomEvent> customEventArray) {
        this.customEventArray = customEventArray;
        return this;
    }

    public EventsArray addEventArrayItem(CustomEvent customEventArrayItem) {
        if (this.customEventArray == null) {
            this.customEventArray = new ArrayList<CustomEvent>();
        }
        this.customEventArray.add(customEventArrayItem);
        return this;
    }

    /**
     * Get eventArray
     *
     * @return eventArray
     **/
    @ApiModelProperty(value = "")
    @Valid
    public List<CustomEvent> getCustomEventArray() {
        return customEventArray;
    }

    public void setCustomEventArray(List<CustomEvent> customEventArray) {
        this.customEventArray = customEventArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EventsArray eventsArray = (EventsArray) o;
        return Objects.equals(this.customEventArray, eventsArray.customEventArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customEventArray);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EventsArray {\n");

        sb.append("    eventArray: ").append(toIndentedString(customEventArray)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
