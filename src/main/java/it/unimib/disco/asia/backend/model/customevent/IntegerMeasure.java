package it.unimib.disco.asia.backend.model.customevent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A model that describe a certain integer measure in terms of quantity and
 * unitID
 */
@ApiModel(description = "A model that describe a certain integer measure in terms of quantity and unitID")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class IntegerMeasure {
    @JsonProperty("@type")
    private AtTypeEnum _atType = null;
    @JsonProperty("quantity")
    private Integer quantity = null;
    @JsonProperty("quantityUnitId")
    private String quantityUnitId = null;

    public IntegerMeasure _atType(AtTypeEnum _atType) {
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

    public IntegerMeasure quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * A number identifying a generic quantity minimum: 0
     *
     * @return quantity
     **/
    @ApiModelProperty(example = "10", required = true, value = "A number identifying a generic quantity")
    @NotNull

    @Min(0)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public IntegerMeasure quantityUnitId(String quantityUnitId) {
        this.quantityUnitId = quantityUnitId;
        return this;
    }

    /**
     * The specification of the unit in which a quantity is measured
     *
     * @return quantityUnitId
     **/
    @ApiModelProperty(example = "people", required = true, value = "The specification of the unit in which a quantity is measured")
    @NotNull

    public String getQuantityUnitId() {
        return quantityUnitId;
    }

    public void setQuantityUnitId(String quantityUnitId) {
        this.quantityUnitId = quantityUnitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IntegerMeasure integerMeasure = (IntegerMeasure) o;
        return Objects.equals(this._atType, integerMeasure._atType)
                && Objects.equals(this.quantity, integerMeasure.quantity)
                && Objects.equals(this.quantityUnitId, integerMeasure.quantityUnitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_atType, quantity, quantityUnitId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IntegerMeasure {\n");

        sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    quantityUnitId: ").append(toIndentedString(quantityUnitId)).append("\n");
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
