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
 * Model used to express the audience interested in a certain event
 */
@ApiModel(description = "Model used to express the audience interested in a certain event")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-23T10:25:57.123Z[GMT]")
public class AudienceMeasure {
	@JsonProperty("@type")
	private AtTypeEnum _atType = null;
	@JsonProperty("interestedAudience")
	private Integer interestedAudience = null;
	@JsonProperty("attendingAudience")
	private Integer attendingAudience = null;

	public AudienceMeasure _atType(AtTypeEnum _atType) {
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

	public AudienceMeasure interestedAudience(Integer interestedAudience) {
		this.interestedAudience = interestedAudience;
		return this;
	}

	/**
	 * The number of people interested in an event minimum: 0
	 *
	 * @return interestedAudience
	 **/
	@ApiModelProperty(example = "531", required = true, value = "The number of people interested in an event")
	@NotNull

	@Min(0)
	public Integer getInterestedAudience() {
		return interestedAudience;
	}

	public void setInterestedAudience(Integer interestedAudience) {
		this.interestedAudience = interestedAudience;
	}

	public AudienceMeasure attendingAudience(Integer attendingAudience) {
		this.attendingAudience = attendingAudience;
		return this;
	}

	/**
	 * The number of people who plan to attend an event minimum: 0
	 *
	 * @return attendingAudience
	 **/
	@ApiModelProperty(example = "130", required = true, value = "The number of people who plan to attend an event")
	@NotNull

	@Min(0)
	public Integer getAttendingAudience() {
		return attendingAudience;
	}

	public void setAttendingAudience(Integer attendingAudience) {
		this.attendingAudience = attendingAudience;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AudienceMeasure audienceMeasure = (AudienceMeasure) o;
		return Objects.equals(this._atType, audienceMeasure._atType)
				&& Objects.equals(this.interestedAudience, audienceMeasure.interestedAudience)
				&& Objects.equals(this.attendingAudience, audienceMeasure.attendingAudience);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atType, interestedAudience, attendingAudience);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AudienceMeasure {\n");

		sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
		sb.append("    interestedAudience: ").append(toIndentedString(interestedAudience)).append("\n");
		sb.append("    attendingAudience: ").append(toIndentedString(attendingAudience)).append("\n");
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
