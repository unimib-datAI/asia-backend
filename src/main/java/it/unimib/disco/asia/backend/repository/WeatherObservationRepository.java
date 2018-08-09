package it.unimib.disco.asia.backend.repository;

import com.arangodb.springframework.annotation.Param;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;

import it.unimib.disco.asia.backend.model.WeatherObservation;

import java.util.Date;

public interface WeatherObservationRepository extends ArangoRepository<WeatherObservation>{

	@Query("let aggr = @aggregators\n" +
			"let isoDates = (for d in @dates return DATE_FORMAT(DATE_ISO8601(d), \"%yyyy-%mm-%ddT%hh:%ii:%ssZ\"))\n" +
			"let measurements = (for measurement in `daily-weather-germany-regions-combined`\n" +
			"    FILTER  measurement.validTime IN isoDates \n" +
			"        and measurement.geonameId IN @geoIds\n" +
			"    let weatherParams = (for param in @params return {'id': param, 'value': measurement[param] })\n" +
			"    return {'geonamesId': measurement.geonameId,\n" +
			"            'validTime': measurement.validTime,\n" +
			"\t\t\t'validityDateTime': measurement.validityDateTime,\n" +
			"\t\t\t'weatherParameters': weatherParams }\n" +
			"\t)\n" +
			"for offset in @offsets\n" +
			"    for measurement in measurements\n" +
			"        filter measurement.validityDateTime == DATE_FORMAT(DATE_ADD(measurement.validTime, offset, \"days\"), \"%yyyy-%mm-%ddT%hh:%ii:%ssZ\")\n" +
			"        return {'geonamesId': measurement.geonamesId,\n" +
			"            'validTime': measurement.validTime,\n" +
			"\t\t\t'validityDateTime': measurement.validityDateTime,\n" +
			"\t\t\t'weatherParameters': measurement.weatherParameters,\n" +
			"\t\t\t'offset': offset}")
	Iterable<WeatherObservation> weatherQuery(@Param("geoIds") int[] ids,
											 @Param("dates") Date[] dates,
                                             @Param("aggregators") String[] aggregators,
                                             @Param("params") String[] params,
                                             @Param("offsets") int[] offsets);
}
