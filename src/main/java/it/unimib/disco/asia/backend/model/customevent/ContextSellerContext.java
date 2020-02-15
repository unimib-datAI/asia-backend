package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ContextSellerContext
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class ContextSellerContext {
    @JsonProperty("@base")
    private AtBaseEnum _atBase = null;

    public ContextSellerContext _atBase(AtBaseEnum _atBase) {
        this._atBase = _atBase;
        return this;
    }

    /**
     * Get _atBase
     *
     * @return _atBase
     **/
    @ApiModelProperty(value = "")

    public AtBaseEnum getAtBase() {
        return _atBase;
    }

    public void setAtBase(AtBaseEnum _atBase) {
        this._atBase = _atBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContextSellerContext contextSellerContext = (ContextSellerContext) o;
        return Objects.equals(this._atBase, contextSellerContext._atBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atBase);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContextSellerContext {\n");

        sb.append("    _atBase: ").append(toIndentedString(_atBase)).append("\n");
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
     * Gets or Sets _atBase
     */
    public enum AtBaseEnum {
        _RDF_SELLER_("/rdf/seller/");

        private String value;

        AtBaseEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AtBaseEnum fromValue(String text) {
            for (AtBaseEnum b : AtBaseEnum.values()) {
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
