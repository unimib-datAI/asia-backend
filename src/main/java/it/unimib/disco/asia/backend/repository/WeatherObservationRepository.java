package it.unimib.disco.asia.backend.repository;


import com.arangodb.springframework.annotation.Param;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import it.unimib.disco.asia.backend.model.WeatherObservation;

import java.util.Date;

public interface WeatherObservationRepository extends ArangoRepository<WeatherObservation>{

	@Query("let isoDates = (for d in @dates return DATE_FORMAT(DATE_ISO8601(d), \"%yyyy-%mm-%ddT%hh:%ii:%ssZ\"))\n" +
			"for measurement in `daily-weather-germany-regions-combined`\n" +
			"    for off in @offsets\n" +
			"        for par in @params\n" +
			"            FILTER measurement.validTime IN isoDates and measurement.geonameId IN @geoIds\n" +
			"            FILTER measurement.validityDateTime >= DATE_FORMAT(DATE_ADD(measurement.validTime, off, \"days\"), \"%yyyy-%mm-%ddT00:00:00Z\") AND\n" +
			"                measurement.validityDateTime <= DATE_FORMAT(DATE_ADD(measurement.validTime, off, \"days\"), \"%yyyy-%mm-%ddT23:59:59Z\")\n" +
			"            SORT measurement.validityDateTime ASC\n" +
			"            COLLECT geonamesId = measurement.geonameId,\n" +
			"                date = measurement.validTime,\n" +
			"                offset = off\n" +
			"                INTO groupByIdDateOffset\n" +
			"            let weatherParameters = (\n" +
			"                for group in groupByIdDateOffset\n" +
			"                    COLLECT param = group.par into groupByParam\n" +
			"                    sort groupByParam.group.measurement.validityDateTime ASC\n" +
			"                    let avgRes = {\n" +
			"                        \"minValue\": MIN(groupByParam[*].group.measurement[param]),\n" +
			"                        \"maxValue\": MAX(groupByParam[*].group.measurement[param]),\n" +
			"                        \"avgValue\": AVERAGE(groupByParam[*].group.measurement[param])\n" +
			"                    }\n" +
			"                    let cumRes = {\n" +
			"                        \"cumulValue\": LAST(groupByParam[*]).group.measurement[param] - FIRST(groupByParam[*]).group.measurement[param]\n" +
			"                    }\n" +
			"                    RETURN param in @cumulatedParams ? MERGE({\"id\": param}, cumRes) : MERGE({\"id\": param}, avgRes) \n" +
			"            )\n" +
			"            return {\n" +
			"                geonamesId,\n" +
			"                date,\n" +
			"                offset,\n" +
			"                weatherParameters\n" +
			"            }")
	Iterable<WeatherObservation> weatherQuery(@Param("geoIds") int[] ids,
											 @Param("dates") Date[] dates,
											 @Param("cumulatedParams") String[] cumulatedParams,
                                             @Param("params") String[] params,
                                             @Param("offsets") int[] offsets);
}
