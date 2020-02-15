package it.unimib.disco.asia.backend.model.customevent;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Field;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Model containing event info
 *
 * @param <OneOfEventMeasure>
 * @param <OneOfEventProduct>
 */
@ApiModel(description = "Model containing event info")
@Validated
@Document(value = "CustomEvents")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class CustomEvent<OneOfEventMeasure, OneOfEventProduct> {

    @Id
    @JsonProperty("_id")
    private String _id = null;


    public String get_id() {
        return _id;
    }

    /**
     * It defines semantically the event and cannot be changed. It has to be
     * 'ews:Event'
     */


    @JsonProperty("@type")
    @Field("@type")
    private String _atType = null;

    @JsonProperty("identifier")
    private String identifier = null;

    @JsonProperty("name")
    private Object name = null;

    @JsonProperty("description")
    private Object description = null;

    @JsonProperty("source")
    private Object source = null;

    @JsonProperty("channelCode")
    private Object channelCode = null;

    @JsonProperty("channelDescription")
    private Object channelDescription = null;

    @JsonProperty("startDate")
    private String startDate = null;

    @JsonProperty("endDate")
    private String endDate = null;

    @JsonProperty("category")
    private Object category = null;

    @JsonProperty("product")
    private OneOfEventProduct product = null;

    @JsonProperty("measure")
    private OneOfEventMeasure measure = null;

    @JsonProperty("location")
    private Object location = null;

    public CustomEvent _atType(String _atType) {
        this._atType = _atType;
        return this;
    }

    /**
     * It defines semantically the event and cannot be changed. It has to be
     * 'ews:Event'
     *
     * @return _atType
     **/
    @ApiModelProperty(value = "It defines semantically the event and cannot be changed. It has to be 'ews:Event'")

    public String getAtType() {
        return _atType;
    }

    public void setAtType(String _atType) {
        this._atType = _atType;
    }

    public CustomEvent identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     * An identifier of an event
     *
     * @return identifier
     **/
    @ApiModelProperty(example = "US12345", required = true, value = "An identifier of an event")
    @NotNull

    @Size(min = 3, max = 100)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public CustomEvent name(Object name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the item
     *
     * @return name
     **/
    @ApiModelProperty(required = true, value = "The name of the item")
    @NotNull

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public CustomEvent description(Object description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the item
     *
     * @return description
     **/
    @ApiModelProperty(value = "A description of the item")

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public CustomEvent source(Object source) {
        this.source = source;
        return this;
    }

    /**
     * A description of the source of the event
     *
     * @return source
     **/
    @ApiModelProperty(value = "A description of the source of the event")

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public CustomEvent channelCode(Object channelCode) {
        this.channelCode = channelCode;
        return this;
    }

    /**
     * A code associated with a channel in a marketing event
     *
     * @return channelCode
     **/
    @ApiModelProperty(value = "A code associated with a channel in a marketing event")

    public Object getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(Object channelCode) {
        this.channelCode = channelCode;
    }

    public CustomEvent channelDescription(Object channelDescription) {
        this.channelDescription = channelDescription;
        return this;
    }

    /**
     * A description associated with a channel in a marketing event
     *
     * @return channelDescription
     **/
    @ApiModelProperty(value = "A description associated with a channel in a marketing event")

    public Object getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(Object channelDescription) {
        this.channelDescription = channelDescription;
    }

    public CustomEvent startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The start date and time of the item (in ISO8601 date format)
     *
     * @return startDate
     **/
    @ApiModelProperty(example = "2016-04-06T10:10:09Z", required = true, value = "The start date and time of the item (in ISO8601 date format)")
    @NotNull

    @Valid
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public CustomEvent endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The end date and time of the item (in ISO8601 date format)
     *
     * @return endDate
     **/
    @ApiModelProperty(example = "2016-05-06T10:10:09Z", value = "The end date and time of the item (in ISO8601 date format)")

    @Valid
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public CustomEvent category(Object category) {
        this.category = category;
        return this;
    }

    /**
     * A category for an event
     *
     * @return category
     **/
    @ApiModelProperty(value = "A category for an event")

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public CustomEvent product(OneOfEventProduct product) {
        this.product = product;
        return this;
    }

    /**
     * This field contains a reference to a product in form of a URI or an object
     * containing information about the object
     *
     * @return product
     **/
    @ApiModelProperty(value = "This field contains a reference to a product in form of a URI or an object containing information about the object")

    public OneOfEventProduct getProduct() {
        return product;
    }

    public void setProduct(OneOfEventProduct product) {
        this.product = product;
    }

    public CustomEvent measure(OneOfEventMeasure measure) {
        this.measure = measure;
        return this;
    }

    /**
     * This model identifies and describes the particular measure the event
     * predicates on
     *
     * @return measure
     **/
    @ApiModelProperty(value = "This model identifies and describes the particular measure the event predicates on")

    public OneOfEventMeasure getMeasure() {
        return measure;
    }

    public void setMeasure(OneOfEventMeasure measure) {
        this.measure = measure;
    }

    public CustomEvent location(Object location) {
        this.location = location;
        return this;
    }

    /**
     * The location where, of for example the event is happening, an organization is
     * located, or an action takes place
     *
     * @return location
     **/
    @ApiModelProperty(value = "The location where, of for example the event is happening, an organization is located, or an action takes place")

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomEvent customEvent = (CustomEvent) o;
        return Objects.equals(this._atType, customEvent._atType) && Objects.equals(this.identifier, customEvent.identifier)
                && Objects.equals(this.name, customEvent.name) && Objects.equals(this.description, customEvent.description)
                && Objects.equals(this.source, customEvent.source) && Objects.equals(this.channelCode, customEvent.channelCode)
                && Objects.equals(this.channelDescription, customEvent.channelDescription)
                && Objects.equals(this.startDate, customEvent.startDate) && Objects.equals(this.endDate, customEvent.endDate)
                && Objects.equals(this.category, customEvent.category) && Objects.equals(this.product, customEvent.product)
                && Objects.equals(this.measure, customEvent.measure) && Objects.equals(this.location, customEvent.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atType, identifier, name, description, source, channelCode, channelDescription, startDate,
                endDate, category, product, measure, location);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Event {\n");

        sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    channelCode: ").append(toIndentedString(channelCode)).append("\n");
        sb.append("    channelDescription: ").append(toIndentedString(channelDescription)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    product: ").append(toIndentedString(product)).append("\n");
        sb.append("    measure: ").append(toIndentedString(measure)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
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
