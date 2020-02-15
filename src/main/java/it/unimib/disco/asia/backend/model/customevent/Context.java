package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * context field used in json-ld, this object is static and should be left as it
 * is.
 */
@ApiModel(description = "context field used in json-ld, this object is static and should be left as it is.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class Context {
    @JsonProperty("@version")
    private AtVersionEnum _atVersion = null;
    @JsonProperty("@base")
    private AtBaseEnum _atBase = null;
    @JsonProperty("schema")
    private SchemaEnum schema = null;
    @JsonProperty("ews")
    private EwsEnum ews = null;
    @JsonProperty("ewsr")
    private EwsrEnum ewsr = null;
    @JsonProperty("xsd")
    private XsdEnum xsd = null;
    @JsonProperty("lang")
    private LangEnum lang = null;
    @JsonProperty("text")
    private TextEnum text = null;
    @JsonProperty("identifier")
    private IdentifierEnum identifier = null;
    @JsonProperty("eventArray")
    private ContextEventArray eventArray = null;
    @JsonProperty("name")
    private ContextName name = null;
    @JsonProperty("description")
    private ContextDescription description = null;
    @JsonProperty("source")
    private ContextSource source = null;
    @JsonProperty("channelCode")
    private ContextChannelCode channelCode = null;
    @JsonProperty("channelDescription")
    private ContextChannelDescription channelDescription = null;
    @JsonProperty("startDate")
    private ContextStartDate startDate = null;
    @JsonProperty("endDate")
    private ContextEndDate endDate = null;
    @JsonProperty("category")
    private ContextCategory category = null;
    @JsonProperty("product")
    private ContextProduct product = null;
    @JsonProperty("gtin13")
    private ContextGtin13 gtin13 = null;
    @JsonProperty("seller")
    private ContextSeller seller = null;
    @JsonProperty("sku")
    private ContextSku sku = null;
    @JsonProperty("catalogId")
    private ContextCatalogId catalogId = null;
    @JsonProperty("measure")
    private ContextMeasure measure = null;
    @JsonProperty("quantity")
    private ContextQuantity quantity = null;
    @JsonProperty("quantityUnitId")
    private ContextQuantityUnitId quantityUnitId = null;
    @JsonProperty("interestedAudience")
    private ContextInterestedAudience interestedAudience = null;
    @JsonProperty("attendingAudience")
    private ContextAttendingAudience attendingAudience = null;
    @JsonProperty("priceChanged")
    private ContextPriceChanged priceChanged = null;
    @JsonProperty("priceChange")
    private ContextPriceChange priceChange = null;
    @JsonProperty("price")
    private ContextPrice price = null;
    @JsonProperty("discount")
    private ContextDiscount discount = null;
    @JsonProperty("location")
    private ContextLocation location = null;
    @JsonProperty("addressLocality")
    private ContextAddressLocality addressLocality = null;
    @JsonProperty("addressCountry")
    private ContextAddressCountry addressCountry = null;
    @JsonProperty("addressRegion")
    private ContextAddressRegion addressRegion = null;
    @JsonProperty("streetAddress")
    private ContextStreetAddress streetAddress = null;
    @JsonProperty("postalCode")
    private ContextPostalCode postalCode = null;
    @JsonProperty("latitude")
    private ContextLatitude latitude = null;
    @JsonProperty("longitude")
    private ContextLongitude longitude = null;
    @JsonProperty("address")
    private ContextAddress address = null;

    public Context _atVersion(AtVersionEnum _atVersion) {
        this._atVersion = _atVersion;
        return this;
    }

    /**
     * Get _atVersion
     *
     * @return _atVersion
     **/
    @ApiModelProperty(value = "")

    public AtVersionEnum getAtVersion() {
        return _atVersion;
    }

    public void setAtVersion(AtVersionEnum _atVersion) {
        this._atVersion = _atVersion;
    }

    public Context _atBase(AtBaseEnum _atBase) {
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

    public Context schema(SchemaEnum schema) {
        this.schema = schema;
        return this;
    }

    /**
     * Get schema
     *
     * @return schema
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public SchemaEnum getSchema() {
        return schema;
    }

    public void setSchema(SchemaEnum schema) {
        this.schema = schema;
    }

    public Context ews(EwsEnum ews) {
        this.ews = ews;
        return this;
    }

    /**
     * Get ews
     *
     * @return ews
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public EwsEnum getEws() {
        return ews;
    }

    public void setEws(EwsEnum ews) {
        this.ews = ews;
    }

    public Context ewsr(EwsrEnum ewsr) {
        this.ewsr = ewsr;
        return this;
    }

    /**
     * Get ewsr
     *
     * @return ewsr
     **/
    @ApiModelProperty(value = "")

    public EwsrEnum getEwsr() {
        return ewsr;
    }

    public void setEwsr(EwsrEnum ewsr) {
        this.ewsr = ewsr;
    }

    public Context xsd(XsdEnum xsd) {
        this.xsd = xsd;
        return this;
    }

    /**
     * Get xsd
     *
     * @return xsd
     **/
    @ApiModelProperty(value = "")

    public XsdEnum getXsd() {
        return xsd;
    }

    public void setXsd(XsdEnum xsd) {
        this.xsd = xsd;
    }

    public Context lang(LangEnum lang) {
        this.lang = lang;
        return this;
    }

    /**
     * Get lang
     *
     * @return lang
     **/
    @ApiModelProperty(value = "")

    public LangEnum getLang() {
        return lang;
    }

    public void setLang(LangEnum lang) {
        this.lang = lang;
    }

    public Context text(TextEnum text) {
        this.text = text;
        return this;
    }

    /**
     * Get text
     *
     * @return text
     **/
    @ApiModelProperty(value = "")

    public TextEnum getText() {
        return text;
    }

    public void setText(TextEnum text) {
        this.text = text;
    }

    public Context identifier(IdentifierEnum identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     * Get identifier
     *
     * @return identifier
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public IdentifierEnum getIdentifier() {
        return identifier;
    }

    public void setIdentifier(IdentifierEnum identifier) {
        this.identifier = identifier;
    }

    public Context eventArray(ContextEventArray eventArray) {
        this.eventArray = eventArray;
        return this;
    }

    /**
     * Get eventArray
     *
     * @return eventArray
     **/
    @ApiModelProperty(value = "")

    @Valid
    public ContextEventArray getEventArray() {
        return eventArray;
    }

    public void setEventArray(ContextEventArray eventArray) {
        this.eventArray = eventArray;
    }

    public Context name(ContextName name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextName getName() {
        return name;
    }

    public void setName(ContextName name) {
        this.name = name;
    }

    public Context description(ContextDescription description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextDescription getDescription() {
        return description;
    }

    public void setDescription(ContextDescription description) {
        this.description = description;
    }

    public Context source(ContextSource source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     *
     * @return source
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextSource getSource() {
        return source;
    }

    public void setSource(ContextSource source) {
        this.source = source;
    }

    public Context channelCode(ContextChannelCode channelCode) {
        this.channelCode = channelCode;
        return this;
    }

    /**
     * Get channelCode
     *
     * @return channelCode
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextChannelCode getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(ContextChannelCode channelCode) {
        this.channelCode = channelCode;
    }

    public Context channelDescription(ContextChannelDescription channelDescription) {
        this.channelDescription = channelDescription;
        return this;
    }

    /**
     * Get channelDescription
     *
     * @return channelDescription
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextChannelDescription getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(ContextChannelDescription channelDescription) {
        this.channelDescription = channelDescription;
    }

    public Context startDate(ContextStartDate startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     *
     * @return startDate
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextStartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(ContextStartDate startDate) {
        this.startDate = startDate;
    }

    public Context endDate(ContextEndDate endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     *
     * @return endDate
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextEndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(ContextEndDate endDate) {
        this.endDate = endDate;
    }

    public Context category(ContextCategory category) {
        this.category = category;
        return this;
    }

    /**
     * Get category
     *
     * @return category
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextCategory getCategory() {
        return category;
    }

    public void setCategory(ContextCategory category) {
        this.category = category;
    }

    public Context product(ContextProduct product) {
        this.product = product;
        return this;
    }

    /**
     * Get product
     *
     * @return product
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextProduct getProduct() {
        return product;
    }

    public void setProduct(ContextProduct product) {
        this.product = product;
    }

    public Context gtin13(ContextGtin13 gtin13) {
        this.gtin13 = gtin13;
        return this;
    }

    /**
     * Get gtin13
     *
     * @return gtin13
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextGtin13 getGtin13() {
        return gtin13;
    }

    public void setGtin13(ContextGtin13 gtin13) {
        this.gtin13 = gtin13;
    }

    public Context seller(ContextSeller seller) {
        this.seller = seller;
        return this;
    }

    /**
     * Get seller
     *
     * @return seller
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextSeller getSeller() {
        return seller;
    }

    public void setSeller(ContextSeller seller) {
        this.seller = seller;
    }

    public Context sku(ContextSku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get sku
     *
     * @return sku
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextSku getSku() {
        return sku;
    }

    public void setSku(ContextSku sku) {
        this.sku = sku;
    }

    public Context catalogId(ContextCatalogId catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    /**
     * Get catalogId
     *
     * @return catalogId
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextCatalogId getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(ContextCatalogId catalogId) {
        this.catalogId = catalogId;
    }

    public Context measure(ContextMeasure measure) {
        this.measure = measure;
        return this;
    }

    /**
     * Get measure
     *
     * @return measure
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextMeasure getMeasure() {
        return measure;
    }

    public void setMeasure(ContextMeasure measure) {
        this.measure = measure;
    }

    public Context quantity(ContextQuantity quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Get quantity
     *
     * @return quantity
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextQuantity getQuantity() {
        return quantity;
    }

    public void setQuantity(ContextQuantity quantity) {
        this.quantity = quantity;
    }

    public Context quantityUnitId(ContextQuantityUnitId quantityUnitId) {
        this.quantityUnitId = quantityUnitId;
        return this;
    }

    /**
     * Get quantityUnitId
     *
     * @return quantityUnitId
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextQuantityUnitId getQuantityUnitId() {
        return quantityUnitId;
    }

    public void setQuantityUnitId(ContextQuantityUnitId quantityUnitId) {
        this.quantityUnitId = quantityUnitId;
    }

    public Context interestedAudience(ContextInterestedAudience interestedAudience) {
        this.interestedAudience = interestedAudience;
        return this;
    }

    /**
     * Get interestedAudience
     *
     * @return interestedAudience
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextInterestedAudience getInterestedAudience() {
        return interestedAudience;
    }

    public void setInterestedAudience(ContextInterestedAudience interestedAudience) {
        this.interestedAudience = interestedAudience;
    }

    public Context attendingAudience(ContextAttendingAudience attendingAudience) {
        this.attendingAudience = attendingAudience;
        return this;
    }

    /**
     * Get attendingAudience
     *
     * @return attendingAudience
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextAttendingAudience getAttendingAudience() {
        return attendingAudience;
    }

    public void setAttendingAudience(ContextAttendingAudience attendingAudience) {
        this.attendingAudience = attendingAudience;
    }

    public Context priceChanged(ContextPriceChanged priceChanged) {
        this.priceChanged = priceChanged;
        return this;
    }

    /**
     * Get priceChanged
     *
     * @return priceChanged
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextPriceChanged getPriceChanged() {
        return priceChanged;
    }

    public void setPriceChanged(ContextPriceChanged priceChanged) {
        this.priceChanged = priceChanged;
    }

    public Context priceChange(ContextPriceChange priceChange) {
        this.priceChange = priceChange;
        return this;
    }

    /**
     * Get priceChange
     *
     * @return priceChange
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextPriceChange getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(ContextPriceChange priceChange) {
        this.priceChange = priceChange;
    }

    public Context price(ContextPrice price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     *
     * @return price
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextPrice getPrice() {
        return price;
    }

    public void setPrice(ContextPrice price) {
        this.price = price;
    }

    public Context discount(ContextDiscount discount) {
        this.discount = discount;
        return this;
    }

    /**
     * Get discount
     *
     * @return discount
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(ContextDiscount discount) {
        this.discount = discount;
    }

    public Context location(ContextLocation location) {
        this.location = location;
        return this;
    }

    /**
     * Get location
     *
     * @return location
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextLocation getLocation() {
        return location;
    }

    public void setLocation(ContextLocation location) {
        this.location = location;
    }

    public Context addressLocality(ContextAddressLocality addressLocality) {
        this.addressLocality = addressLocality;
        return this;
    }

    /**
     * Get addressLocality
     *
     * @return addressLocality
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextAddressLocality getAddressLocality() {
        return addressLocality;
    }

    public void setAddressLocality(ContextAddressLocality addressLocality) {
        this.addressLocality = addressLocality;
    }

    public Context addressCountry(ContextAddressCountry addressCountry) {
        this.addressCountry = addressCountry;
        return this;
    }

    /**
     * Get addressCountry
     *
     * @return addressCountry
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextAddressCountry getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(ContextAddressCountry addressCountry) {
        this.addressCountry = addressCountry;
    }

    public Context addressRegion(ContextAddressRegion addressRegion) {
        this.addressRegion = addressRegion;
        return this;
    }

    /**
     * Get addressRegion
     *
     * @return addressRegion
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextAddressRegion getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(ContextAddressRegion addressRegion) {
        this.addressRegion = addressRegion;
    }

    public Context streetAddress(ContextStreetAddress streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    /**
     * Get streetAddress
     *
     * @return streetAddress
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextStreetAddress getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(ContextStreetAddress streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Context postalCode(ContextPostalCode postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Get postalCode
     *
     * @return postalCode
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextPostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(ContextPostalCode postalCode) {
        this.postalCode = postalCode;
    }

    public Context latitude(ContextLatitude latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Get latitude
     *
     * @return latitude
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextLatitude getLatitude() {
        return latitude;
    }

    public void setLatitude(ContextLatitude latitude) {
        this.latitude = latitude;
    }

    public Context longitude(ContextLongitude longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * Get longitude
     *
     * @return longitude
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextLongitude getLongitude() {
        return longitude;
    }

    public void setLongitude(ContextLongitude longitude) {
        this.longitude = longitude;
    }

    public Context address(ContextAddress address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    public ContextAddress getAddress() {
        return address;
    }

    public void setAddress(ContextAddress address) {
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
        Context context = (Context) o;
        return Objects.equals(this._atVersion, context._atVersion) && Objects.equals(this._atBase, context._atBase)
                && Objects.equals(this.schema, context.schema) && Objects.equals(this.ews, context.ews)
                && Objects.equals(this.ewsr, context.ewsr) && Objects.equals(this.xsd, context.xsd)
                && Objects.equals(this.lang, context.lang) && Objects.equals(this.text, context.text)
                && Objects.equals(this.identifier, context.identifier)
                && Objects.equals(this.eventArray, context.eventArray) && Objects.equals(this.name, context.name)
                && Objects.equals(this.description, context.description) && Objects.equals(this.source, context.source)
                && Objects.equals(this.channelCode, context.channelCode)
                && Objects.equals(this.channelDescription, context.channelDescription)
                && Objects.equals(this.startDate, context.startDate) && Objects.equals(this.endDate, context.endDate)
                && Objects.equals(this.category, context.category) && Objects.equals(this.product, context.product)
                && Objects.equals(this.gtin13, context.gtin13) && Objects.equals(this.seller, context.seller)
                && Objects.equals(this.sku, context.sku) && Objects.equals(this.catalogId, context.catalogId)
                && Objects.equals(this.measure, context.measure) && Objects.equals(this.quantity, context.quantity)
                && Objects.equals(this.quantityUnitId, context.quantityUnitId)
                && Objects.equals(this.interestedAudience, context.interestedAudience)
                && Objects.equals(this.attendingAudience, context.attendingAudience)
                && Objects.equals(this.priceChanged, context.priceChanged)
                && Objects.equals(this.priceChange, context.priceChange) && Objects.equals(this.price, context.price)
                && Objects.equals(this.discount, context.discount) && Objects.equals(this.location, context.location)
                && Objects.equals(this.addressLocality, context.addressLocality)
                && Objects.equals(this.addressCountry, context.addressCountry)
                && Objects.equals(this.addressRegion, context.addressRegion)
                && Objects.equals(this.streetAddress, context.streetAddress)
                && Objects.equals(this.postalCode, context.postalCode)
                && Objects.equals(this.latitude, context.latitude) && Objects.equals(this.longitude, context.longitude)
                && Objects.equals(this.address, context.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atVersion, _atBase, schema, ews, ewsr, xsd, lang, text, identifier, eventArray, name,
                description, source, channelCode, channelDescription, startDate, endDate, category, product, gtin13,
                seller, sku, catalogId, measure, quantity, quantityUnitId, interestedAudience, attendingAudience,
                priceChanged, priceChange, price, discount, location, addressLocality, addressCountry, addressRegion,
                streetAddress, postalCode, latitude, longitude, address);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Context {\n");

        sb.append("    _atVersion: ").append(toIndentedString(_atVersion)).append("\n");
        sb.append("    _atBase: ").append(toIndentedString(_atBase)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
        sb.append("    ews: ").append(toIndentedString(ews)).append("\n");
        sb.append("    ewsr: ").append(toIndentedString(ewsr)).append("\n");
        sb.append("    xsd: ").append(toIndentedString(xsd)).append("\n");
        sb.append("    lang: ").append(toIndentedString(lang)).append("\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
        sb.append("    eventArray: ").append(toIndentedString(eventArray)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    channelCode: ").append(toIndentedString(channelCode)).append("\n");
        sb.append("    channelDescription: ").append(toIndentedString(channelDescription)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    product: ").append(toIndentedString(product)).append("\n");
        sb.append("    gtin13: ").append(toIndentedString(gtin13)).append("\n");
        sb.append("    seller: ").append(toIndentedString(seller)).append("\n");
        sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    measure: ").append(toIndentedString(measure)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    quantityUnitId: ").append(toIndentedString(quantityUnitId)).append("\n");
        sb.append("    interestedAudience: ").append(toIndentedString(interestedAudience)).append("\n");
        sb.append("    attendingAudience: ").append(toIndentedString(attendingAudience)).append("\n");
        sb.append("    priceChanged: ").append(toIndentedString(priceChanged)).append("\n");
        sb.append("    priceChange: ").append(toIndentedString(priceChange)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    addressLocality: ").append(toIndentedString(addressLocality)).append("\n");
        sb.append("    addressCountry: ").append(toIndentedString(addressCountry)).append("\n");
        sb.append("    addressRegion: ").append(toIndentedString(addressRegion)).append("\n");
        sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
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
     * Gets or Sets _atVersion
     */
    public enum AtVersionEnum {
        NUMBER_1_DOT_1(1.1f);

        private Float value;

        AtVersionEnum(Float value) {
            this.value = value;
        }

        @JsonCreator
        public static AtVersionEnum fromValue(String text) {
            for (AtVersionEnum b : AtVersionEnum.values()) {
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
     * Gets or Sets _atBase
     */
    public enum AtBaseEnum {
        HTTP_EW_SHOPP_EU_("http://ew-shopp.eu/");

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

    /**
     * Gets or Sets schema
     */
    public enum SchemaEnum {
        HTTP_SCHEMA_ORG_("http://schema.org/");

        private String value;

        SchemaEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static SchemaEnum fromValue(String text) {
            for (SchemaEnum b : SchemaEnum.values()) {
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
     * Gets or Sets ews
     */
    public enum EwsEnum {
        HTTP_EW_SHOPP_EU_ONTOLOGY_("http://ew-shopp.eu/ontology/");

        private String value;

        EwsEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static EwsEnum fromValue(String text) {
            for (EwsEnum b : EwsEnum.values()) {
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
     * Gets or Sets ewsr
     */
    public enum EwsrEnum {
        RDF("http://ew-shopp.eu/data/rdf");

        private String value;

        EwsrEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static EwsrEnum fromValue(String text) {
            for (EwsrEnum b : EwsrEnum.values()) {
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
     * Gets or Sets xsd
     */
    public enum XsdEnum {
        HTTP_WWW_W3_ORG_2001_XMLSCHEMA_("http://www.w3.org/2001/XMLSchema#");

        private String value;

        XsdEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static XsdEnum fromValue(String text) {
            for (XsdEnum b : XsdEnum.values()) {
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
     * Gets or Sets lang
     */
    public enum LangEnum {
        LANGUAGE("@language");

        private String value;

        LangEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static LangEnum fromValue(String text) {
            for (LangEnum b : LangEnum.values()) {
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
     * Gets or Sets text
     */
    public enum TextEnum {
        VALUE("@value");

        private String value;

        TextEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static TextEnum fromValue(String text) {
            for (TextEnum b : TextEnum.values()) {
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
     * Gets or Sets identifier
     */
    public enum IdentifierEnum {
        ID("@id");

        private String value;

        IdentifierEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static IdentifierEnum fromValue(String text) {
            for (IdentifierEnum b : IdentifierEnum.values()) {
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
