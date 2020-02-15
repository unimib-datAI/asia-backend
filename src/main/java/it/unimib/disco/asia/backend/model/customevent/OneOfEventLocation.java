package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * OneOfEventLocation
 */
//@JsonDeserialize(as = PostalAddress.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, defaultImpl = Object.class)
@JsonSubTypes({
        @Type(value = Place.class, name = "ews:Place"),
        @Type(value = PostalAddress.class, name = "ews:PostalAddress")
})
public interface OneOfEventLocation {

}
