package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * EW-Shopp product description
 */
@ApiModel(description = "EW-Shopp product description")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class Product {
    @JsonProperty("@type")
    private AtTypeEnum _atType = null;
    @JsonProperty("identifier")
    private String identifier = null;
    @JsonProperty("gtin13")
    private String gtin13 = null;
    @JsonProperty("description")
    private Object description = null;
    @JsonProperty("seller")
    private Seller seller = null;
    @JsonProperty("sku")
    private String sku = null;
    @JsonProperty("catalogId")
    private String catalogId = null;
    @JsonProperty("category")
    private Category category = null;

    public Product _atType(AtTypeEnum _atType) {
        this._atType = _atType;
        return this;
    }

    /**
     * It represents semantically the type product and cannot be changed. It has to be equal to 'ews:Product'
     *
     * @return _atType
     **/
    @ApiModelProperty(value = "It represents semantically the type product and cannot be changed. It has to be equal to 'ews:Product'")

    public AtTypeEnum getAtType() {
        return _atType;
    }

    public void setAtType(AtTypeEnum _atType) {
        this._atType = _atType;
    }

    public Product identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     * ID of the product
     *
     * @return identifier
     **/
    @ApiModelProperty(example = "156789", value = "ID of the product")

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Product gtin13(String gtin13) {
        this.gtin13 = gtin13;
        return this;
    }

    /**
     * The GTIN-13 code of the product, or the product to with the offer refers. This is equivalent to 13-digit ISBN codes and EAN UCC-13
     *
     * @return gtin13
     **/
    @ApiModelProperty(example = "123456789012", required = true, value = "The GTIN-13 code of the product, or the product to with the offer refers. This is equivalent to 13-digit ISBN codes and EAN UCC-13")
    @NotNull

    public String getGtin13() {
        return gtin13;
    }

    public void setGtin13(String gtin13) {
        this.gtin13 = gtin13;
    }

    public Product description(Object description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the product
     *
     * @return description
     **/
    @ApiModelProperty(value = "A description of the product")

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Product seller(Seller seller) {
        this.seller = seller;
        return this;
    }

    /**
     * Get seller
     *
     * @return seller
     **/
    @ApiModelProperty(value = "")

    @Valid
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product sku(String sku) {
        this.sku = sku;
        return this;
    }

    /**
     * The Stock Keeping Unit (SKU), i.e. a merchant-specific identifier for a product or service, or the product to which the offer refers
     *
     * @return sku
     **/
    @ApiModelProperty(example = "018719ACME/WMD001080165", value = "The Stock Keeping Unit (SKU), i.e. a merchant-specific identifier for a product or service, or the product to which the offer refers")

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product catalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    /**
     * Specify the identifier
     *
     * @return catalogId
     **/
    @ApiModelProperty(example = "xx192s", value = "Specify the identifier")

    @Size(min = 3, max = 100)
    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public Product category(Category category) {
        this.category = category;
        return this;
    }

    /**
     * Get category
     *
     * @return category
     **/
    @ApiModelProperty(value = "")

    @Valid
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(this._atType, product._atType) &&
                Objects.equals(this.identifier, product.identifier) &&
                Objects.equals(this.gtin13, product.gtin13) &&
                Objects.equals(this.description, product.description) &&
                Objects.equals(this.seller, product.seller) &&
                Objects.equals(this.sku, product.sku) &&
                Objects.equals(this.catalogId, product.catalogId) &&
                Objects.equals(this.category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atType, identifier, gtin13, description, seller, sku, catalogId, category);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Product {\n");

        sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
        sb.append("    gtin13: ").append(toIndentedString(gtin13)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    seller: ").append(toIndentedString(seller)).append("\n");
        sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
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
     * It represents semantically the type product and cannot be changed. It has to be equal to 'ews:Product'
     */
    public enum AtTypeEnum {
        PRODUCT("ews:Product");

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
