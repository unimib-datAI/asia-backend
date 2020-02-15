package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * PostalAddress
 */
@JsonTypeName("ews:PostalAddress")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class PostalAddress implements OneOfPlaceAddress, OneOfEventLocation {
    @JsonProperty("@type")
    private AtTypeEnum _atType = null;
    @JsonProperty("addressLocality")
    private Object addressLocality = null;
    @JsonProperty("addressCountry")
    private String addressCountry = null;
    @JsonProperty("addressRegion")
    private Object addressRegion = null;
    @JsonProperty("streetAddress")
    private Object streetAddress = null;
    @JsonProperty("postalCode")
    private String postalCode = null;

    public PostalAddress _atType(AtTypeEnum _atType) {
        this._atType = _atType;
        return this;
    }

    /**
     * It defines semantically the type PostalAddress and cannot be changed. It has
     * to be equal to 'schema:PostalAddress'
     *
     * @return _atType
     **/
    @ApiModelProperty(value = "It defines semantically the type PostalAddress and cannot be changed. It has to be equal to 'schema:PostalAddress'")

    public AtTypeEnum getAtType() {
        return _atType;
    }

    public void setAtType(AtTypeEnum _atType) {
        this._atType = _atType;
    }

    public PostalAddress addressLocality(Object addressLocality) {
        this.addressLocality = addressLocality;
        return this;
    }

    /**
     * Reference to a locality; e.g., Mountain View. See
     * [schema:PostalAddress](http://schema.org/PostalAddress)
     *
     * @return addressLocality
     **/
    @ApiModelProperty(value = "Reference to a locality; e.g., Mountain View. See [schema:PostalAddress](http://schema.org/PostalAddress)")

    public Object getAddressLocality() {
        return addressLocality;
    }

    public void setAddressLocality(Object addressLocality) {
        this.addressLocality = addressLocality;
    }

    public PostalAddress addressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
        return this;
    }

    /**
     * Reference to a country. The two-letter ISO3161-1 alpha-2 country code can be
     * used. See [schema:PostalAddress](http://schema.org/PostalAddress)
     *
     * @return addressCountry
     **/
    @ApiModelProperty(example = "USA", value = "Reference to a country. The two-letter ISO3161-1 alpha-2 country code can be used. See [schema:PostalAddress](http://schema.org/PostalAddress)")

    @Size(max = 100)
    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public PostalAddress addressRegion(Object addressRegion) {
        this.addressRegion = addressRegion;
        return this;
    }

    /**
     * Reference to a region; e.g., CA See
     * [schema:PostalAddress](http://schema.org/PostalAddress)
     *
     * @return addressRegion
     **/
    @ApiModelProperty(value = "Reference to a region; e.g., CA See [schema:PostalAddress](http://schema.org/PostalAddress)")

    public Object getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(Object addressRegion) {
        this.addressRegion = addressRegion;
    }

    public PostalAddress streetAddress(Object streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    /**
     * A string containing info the street address; e.g., 1600 Amphitheatre Pkwy.
     * See [schema:PostalAddress](http://schema.org/PostalAddress)
     *
     * @return streetAddress
     **/
    @ApiModelProperty(value = "A string containing info the street address; e.g., 1600 Amphitheatre Pkwy. See [schema:PostalAddress](http://schema.org/PostalAddress)")

    public Object getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(Object streetAddress) {
        this.streetAddress = streetAddress;
    }

    public PostalAddress postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * The postal code for a location. See
     * [schema:PostalAddress](http://schema.org/PostalAddress)
     *
     * @return postalCode
     **/
    @ApiModelProperty(example = "94043", value = "The postal code for a location. See [schema:PostalAddress](http://schema.org/PostalAddress)")

    @Size(max = 10)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostalAddress postalAddress = (PostalAddress) o;
        return Objects.equals(this._atType, postalAddress._atType)
                && Objects.equals(this.addressLocality, postalAddress.addressLocality)
                && Objects.equals(this.addressCountry, postalAddress.addressCountry)
                && Objects.equals(this.addressRegion, postalAddress.addressRegion)
                && Objects.equals(this.streetAddress, postalAddress.streetAddress)
                && Objects.equals(this.postalCode, postalAddress.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atType, addressLocality, addressCountry, addressRegion, streetAddress, postalCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostalAddress {\n");

        sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
        sb.append("    addressLocality: ").append(toIndentedString(addressLocality)).append("\n");
        sb.append("    addressCountry: ").append(toIndentedString(addressCountry)).append("\n");
        sb.append("    addressRegion: ").append(toIndentedString(addressRegion)).append("\n");
        sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
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
     * It defines semantically the type PostalAddress and cannot be changed. It has
     * to be equal to 'schema:PostalAddress'
     */
    public enum AtTypeEnum {
        POSTALADDRESS("schema:PostalAddress");

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
