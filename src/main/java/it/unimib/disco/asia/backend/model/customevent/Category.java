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
 * A product/event category
 */
@ApiModel(description = "A product/event category")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class Category {
    @JsonProperty("@type")
    private AtTypeEnum _atType = null;
    @JsonProperty("identifier")
    private String identifier = null;
    @JsonProperty("description")
    private String description = null;

    public Category _atType(AtTypeEnum _atType) {
        this._atType = _atType;
        return this;
    }

    /**
     * It define the semantic type for the category, it cannot be changed. It has to
     * be 'ews:Category'
     *
     * @return _atType
     **/
    @ApiModelProperty(value = "It define the semantic type for the category, it cannot be changed. It has to be 'ews:Category'")

    public AtTypeEnum getAtType() {
        return _atType;
    }

    public void setAtType(AtTypeEnum _atType) {
        this._atType = _atType;
    }

    public Category identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     * The category identifier
     *
     * @return identifier
     **/
    @ApiModelProperty(example = "cat1Code", required = true, value = "The category identifier")
    @NotNull

    @Size(min = 3, max = 100)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Category description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The category description
     *
     * @return description
     **/
    @ApiModelProperty(example = "sports", value = "The category description")

    @Size(min = 3, max = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(this._atType, category._atType) && Objects.equals(this.identifier, category.identifier)
                && Objects.equals(this.description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atType, identifier, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Category {\n");

        sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
     * It define the semantic type for the category, it cannot be changed. It has to
     * be 'ews:Category'
     */
    public enum AtTypeEnum {
        CATEGORY("ews:Category");

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
