package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Model used to describe price, price change and discount
 */
@ApiModel(description = "Model used to describe price, price change and discount")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class PriceMeasure {
    @JsonProperty("@type")
    private AtTypeEnum _atType = null;
    @JsonProperty("priceChanged")
    private Boolean priceChanged = false;
    @JsonProperty("discount")
    private OneOfPriceMeasureDiscount discount = null;
    @JsonProperty("priceChange")
    private Float priceChange = 0f;
    @JsonProperty("price")
    private Float price = null;

    public PriceMeasure _atType(AtTypeEnum _atType) {
        this._atType = _atType;
        return this;
    }

    /**
     * It defines semantically a certain measure and cannot be changed. Use
     * 'ews:Measure'
     *
     * @return _atType
     **/
    @ApiModelProperty(value = "It defines semantically a certain measure and cannot be changed. Use 'ews:Measure'")

    public AtTypeEnum getAtType() {
        return _atType;
    }

    public void setAtType(AtTypeEnum _atType) {
        this._atType = _atType;
    }

    public PriceMeasure priceChanged(Boolean priceChanged) {
        this.priceChanged = priceChanged;
        return this;
    }

    /**
     * A measure that assigns a boolean value to specify if the price of a product
     * has changed
     *
     * @return priceChanged
     **/
    @ApiModelProperty(example = "true", value = "A measure that assigns a boolean value to specify if the price of a product has changed")

    public Boolean isPriceChanged() {
        return priceChanged;
    }

    public void setPriceChanged(Boolean priceChanged) {
        this.priceChanged = priceChanged;
    }

    public PriceMeasure discount(OneOfPriceMeasureDiscount discount) {
        this.discount = discount;
        return this;
    }

    /**
     * Any discount applied (to an order)
     *
     * @return discount
     **/
    @ApiModelProperty(value = "Any discount applied (to an order)")

    public OneOfPriceMeasureDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(OneOfPriceMeasureDiscount discount) {
        this.discount = discount;
    }

    public PriceMeasure priceChange(Float priceChange) {
        this.priceChange = priceChange;
        return this;
    }

    /**
     * Price change in %
     *
     * @return priceChange
     **/
    @ApiModelProperty(example = "10.4", value = "Price change in %")

    public Float getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Float priceChange) {
        this.priceChange = priceChange;
    }

    public PriceMeasure price(Float price) {
        this.price = price;
        return this;
    }

    /**
     * The offer price of a product, or of a price component when attached to
     * [PriceSpecification](http://schema.org/PriceSpecification) and its subtypes
     * minimum: 0
     *
     * @return price
     **/
    @ApiModelProperty(example = "130.99", required = true, value = "The offer price of a product, or of a price component when attached to [PriceSpecification](http://schema.org/PriceSpecification) and its subtypes")
    @NotNull

    @DecimalMin("0")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PriceMeasure priceMeasure = (PriceMeasure) o;
        return Objects.equals(this._atType, priceMeasure._atType)
                && Objects.equals(this.priceChanged, priceMeasure.priceChanged)
                && Objects.equals(this.discount, priceMeasure.discount)
                && Objects.equals(this.priceChange, priceMeasure.priceChange)
                && Objects.equals(this.price, priceMeasure.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atType, priceChanged, discount, priceChange, price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PriceMeasure {\n");

        sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
        sb.append("    priceChanged: ").append(toIndentedString(priceChanged)).append("\n");
        sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
        sb.append("    priceChange: ").append(toIndentedString(priceChange)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
     * It defines semantically a certain measure and cannot be changed. Use
     * 'ews:Measure'
     */
    public enum AtTypeEnum {
        MEASURE("ews:Measure");

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
