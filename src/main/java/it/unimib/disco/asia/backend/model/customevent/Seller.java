package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * A product seller
 */
@ApiModel(description = "A product seller")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class Seller {
    @JsonProperty("@type")
    private AtTypeEnum _atType = null;
    @JsonProperty("identifier")
    private String identifier = null;
    @JsonProperty("name")
    private Object name = null;

    public Seller _atType(AtTypeEnum _atType) {
        this._atType = _atType;
        return this;
    }

    /**
     * It defines semantically the seller and cannot be changed. It has to be
     * 'ews:Seller'
     *
     * @return _atType
     **/
    @ApiModelProperty(value = "It defines semantically the seller and cannot be changed. It has to be 'ews:Seller'")

    public AtTypeEnum getAtType() {
        return _atType;
    }

    public void setAtType(AtTypeEnum _atType) {
        this._atType = _atType;
    }

    public Seller identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     * The seller's identifier
     *
     * @return identifier
     **/
    @ApiModelProperty(example = "Sel1Cod", required = true, value = "The seller's identifier")
    @NotNull

    @Size(min = 3, max = 100)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Seller name(Object name) {
        this.name = name;
        return this;
    }

    /**
     * The seller's name
     *
     * @return name
     **/
    @ApiModelProperty(value = "The seller's name")

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Seller seller = (Seller) o;
        return Objects.equals(this._atType, seller._atType) && Objects.equals(this.identifier, seller.identifier)
                && Objects.equals(this.name, seller.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atType, identifier, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Seller {\n");

        sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
     * It defines semantically the seller and cannot be changed. It has to be
     * 'ews:Seller'
     */
    public enum AtTypeEnum {
        SELLER("ews:Seller");

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
