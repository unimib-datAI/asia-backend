package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * ContextEventArray
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class ContextEventArray {
    @JsonProperty("@id")
    private AtIdEnum _atId = null;
    @JsonProperty("@type")
    private AtTypeEnum _atType = null;
    @JsonProperty("@container")
    private AtContainerEnum _atContainer = null;
    @JsonProperty("@context")
    private ContextEventArrayContext _atContext = null;

    public ContextEventArray _atId(AtIdEnum _atId) {
        this._atId = _atId;
        return this;
    }

    /**
     * Get _atId
     *
     * @return _atId
     **/
    @ApiModelProperty(value = "")

    public AtIdEnum getAtId() {
        return _atId;
    }

    public void setAtId(AtIdEnum _atId) {
        this._atId = _atId;
    }

    public ContextEventArray _atType(AtTypeEnum _atType) {
        this._atType = _atType;
        return this;
    }

    /**
     * Get _atType
     *
     * @return _atType
     **/
    @ApiModelProperty(value = "")

    public AtTypeEnum getAtType() {
        return _atType;
    }

    public void setAtType(AtTypeEnum _atType) {
        this._atType = _atType;
    }

    public ContextEventArray _atContainer(AtContainerEnum _atContainer) {
        this._atContainer = _atContainer;
        return this;
    }

    /**
     * Get _atContainer
     *
     * @return _atContainer
     **/
    @ApiModelProperty(value = "")

    public AtContainerEnum getAtContainer() {
        return _atContainer;
    }

    public void setAtContainer(AtContainerEnum _atContainer) {
        this._atContainer = _atContainer;
    }

    public ContextEventArray _atContext(ContextEventArrayContext _atContext) {
        this._atContext = _atContext;
        return this;
    }

    /**
     * Get _atContext
     *
     * @return _atContext
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ContextEventArrayContext getAtContext() {
        return _atContext;
    }

    public void setAtContext(ContextEventArrayContext _atContext) {
        this._atContext = _atContext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContextEventArray contextEventArray = (ContextEventArray) o;
        return Objects.equals(this._atId, contextEventArray._atId)
                && Objects.equals(this._atType, contextEventArray._atType)
                && Objects.equals(this._atContainer, contextEventArray._atContainer)
                && Objects.equals(this._atContext, contextEventArray._atContext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atId, _atType, _atContainer, _atContext);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContextEventArray {\n");

        sb.append("    _atId: ").append(toIndentedString(_atId)).append("\n");
        sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
        sb.append("    _atContainer: ").append(toIndentedString(_atContainer)).append("\n");
        sb.append("    _atContext: ").append(toIndentedString(_atContext)).append("\n");
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
     * Gets or Sets _atId
     */
    public enum AtIdEnum {
        EVENTARRAY("ews:eventArray");

        private String value;

        AtIdEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AtIdEnum fromValue(String text) {
            for (AtIdEnum b : AtIdEnum.values()) {
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

    /**
     * Gets or Sets _atType
     */
    public enum AtTypeEnum {
        ID("@id");

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

    /**
     * Gets or Sets _atContainer
     */
    public enum AtContainerEnum {
        SET("@set");

        private String value;

        AtContainerEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AtContainerEnum fromValue(String text) {
            for (AtContainerEnum b : AtContainerEnum.values()) {
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
