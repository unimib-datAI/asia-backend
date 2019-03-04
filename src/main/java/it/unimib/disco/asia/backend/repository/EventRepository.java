package it.unimib.disco.asia.backend.repository;

import com.arangodb.springframework.annotation.Param;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import it.unimib.disco.asia.backend.model.Event;

import java.util.Date;

public interface EventRepository extends ArangoRepository<Event>{

	@Query("let isoDates = (for d in @dates return DATE_FORMAT(DATE_ISO8601(d), \"%yyyy-%mm-%dd\"))\n" +
			"for event in `events`\n" +
			"FILTER  event.info.eventDate IN isoDates\n" +
			"    and event.info.location.geoNamesId IN @geoIds\n" +
			"    and event.info.categories[*].uri == @catIds\n" +
			"    and LENGTH(event.info.categories[*]) > 0\n" +
			"    collect location = event.info.location.geoNamesId,\n" +
			"            date = event.info.eventDate,\n" +
			"            categories =  event.info.categories[*].uri\n" +
			"            with count into eventsCount\n" +
			"    return {'geonamesId': location,\n" +
			"        'eventDate': date,\n" +
			"        'categories': categories,\n" +
			"        'eventsCount': eventsCount\n" +
			"        }")
	Iterable<Event> eventQuery(@Param("geoIds") String[] ids,
							   @Param("dates") Date[] dates,
							   @Param("catIds") String[] categories);
}
