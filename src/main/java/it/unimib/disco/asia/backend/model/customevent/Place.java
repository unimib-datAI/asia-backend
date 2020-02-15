package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Place
 */
@JsonTypeName("ews:Place")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class Place implements OneOfEventLocation {
    @JsonProperty("@type")
    private AtTypeEnum _atType = null;
    @JsonProperty("name")
    private Object name = null;
    @JsonProperty("description")
    private Object description = null;
    @JsonProperty("latitude")
    private Double latitude = null;
    @JsonProperty("longitude")
    private Double longitude = null;
    @JsonProperty("address")
    private OneOfPlaceAddress address = null;

    public Place _atType(AtTypeEnum _atType) {
        this._atType = _atType;
        return this;
    }

    /**
     * It defines semantically the place and cannot be changed. Use 'ews:Place'
     *
     * @return _atType
     **/
    @ApiModelProperty(value = "It defines semantically the place and cannot be changed. Use 'ews:Place'")

    public AtTypeEnum getAtType() {
        return _atType;
    }

    public void setAtType(AtTypeEnum _atType) {
        this._atType = _atType;
    }

    public Place name(Object name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the Place; e.g., Googleplex
     *
     * @return name
     **/
    @ApiModelProperty(required = true, value = "The name of the Place; e.g., Googleplex")
    @NotNull

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Place description(Object description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the Place; e.g., The Googleplex is the corporate
     * headquarters complex of Google, Inc.
     *
     * @return description
     **/
    @ApiModelProperty(value = "A description of the Place; e.g., The Googleplex is the corporate headquarters complex of Google, Inc.")

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Place latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * The WGS84 latitude of a location. See
     * [schema:GeoCoordinates](http://schema.org/GeoCoordinates) minimum: -90
     * maximum: 90
     *
     * @return latitude
     **/
    @ApiModelProperty(example = "37.42242", value = "The WGS84 latitude of a location. See [schema:GeoCoordinates](http://schema.org/GeoCoordinates)")

    @DecimalMin("-90")
    @DecimalMax("90")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Place longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * The WGS84 longitude of a location. See
     * [schema:GeoCoordinates](http://schema.org/GeoCoordinates) minimum: -180
     * maximum: 180
     *
     * @return longitude
     **/
    @ApiModelProperty(example = "-122.08585", value = "The WGS84 longitude of a location. See [schema:GeoCoordinates](http://schema.org/GeoCoordinates)")

    @DecimalMin("-180")
    @DecimalMax("180")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Place address(OneOfPlaceAddress address) {
        this.address = address;
        return this;
    }

    /**
     * The full address of a location, expressed as a string; e.g., 1600
     * Amphitheatre Pkwy, 94043, Mountain View, CA, USA
     *
     * @return address
     **/
    @ApiModelProperty(value = "The full address of a location, expressed as a string; e.g., 1600 Amphitheatre Pkwy, 94043, Mountain View, CA, USA")

    public OneOfPlaceAddress getAddress() {
        return address;
    }

    public void setAddress(OneOfPlaceAddress address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place place = (Place) o;
        return Objects.equals(this._atType, place._atType) && Objects.equals(this.name, place.name)
                && Objects.equals(this.description, place.description) && Objects.equals(this.latitude, place.latitude)
                && Objects.equals(this.longitude, place.longitude) && Objects.equals(this.address, place.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atType, name, description, latitude, longitude, address);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Place {\n");

        sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
        sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

    /**
     * It defines semantically the place and cannot be changed. Use 'ews:Place'
     */
    public enum AtTypeEnum {
        PLACE("ews:Place");

        private String value;

        AtTypeEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AtTypeEnum fromValue(String text) {
            for (AtTypeEnum b : AtTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }
}
