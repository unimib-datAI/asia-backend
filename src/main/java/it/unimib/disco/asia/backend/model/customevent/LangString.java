package it.unimib.disco.asia.backend.model.customevent;

import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * This object contains text and a two-digit annotation indicating the language
 * of the string. It can be also pure text. In this case the default language is
 * English
 */
@ApiModel(description = "This object contains text and a two-digit annotation indicating the language of the string. It can be also pure text. In this case the default language is English")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class LangString implements OneOfPlaceAddress, OneOfEventLocation {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LangString {\n");

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
