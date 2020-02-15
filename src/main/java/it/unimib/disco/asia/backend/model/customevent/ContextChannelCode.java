package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ContextChannelCode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class ContextChannelCode {
    @JsonProperty("@id")
    private AtIdEnum _atId = null;
    @JsonProperty("@language")
    private AtLanguageEnum _atLanguage = null;

    public ContextChannelCode _atId(AtIdEnum _atId) {
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

    public ContextChannelCode _atLanguage(AtLanguageEnum _atLanguage) {
        this._atLanguage = _atLanguage;
        return this;
    }

    /**
     * Get _atLanguage
     *
     * @return _atLanguage
     **/
    @ApiModelProperty(value = "")

    public AtLanguageEnum getAtLanguage() {
        return _atLanguage;
    }

    public void setAtLanguage(AtLanguageEnum _atLanguage) {
        this._atLanguage = _atLanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContextChannelCode contextChannelCode = (ContextChannelCode) o;
        return Objects.equals(this._atId, contextChannelCode._atId)
                && Objects.equals(this._atLanguage, contextChannelCode._atLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atId, _atLanguage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContextChannelCode {\n");

        sb.append("    _atId: ").append(toIndentedString(_atId)).append("\n");
        sb.append("    _atLanguage: ").append(toIndentedString(_atLanguage)).append("\n");
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
        CHANNELCODE("ews:channelCode");

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
     * Gets or Sets _atLanguage
     */
    public enum AtLanguageEnum {
        EN("en");

        private String value;

        AtLanguageEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AtLanguageEnum fromValue(String text) {
            for (AtLanguageEnum b : AtLanguageEnum.values()) {
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
