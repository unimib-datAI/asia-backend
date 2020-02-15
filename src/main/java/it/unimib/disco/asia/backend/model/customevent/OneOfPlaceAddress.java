package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * OneOfPlaceAddress
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, defaultImpl = LangString.class)
@JsonSubTypes({
        @Type(value = PostalAddress.class, name = "ews:PostalAddress")
})
public interface OneOfPlaceAddress {

}
