package it.unimib.disco.asia.backend.repository;


import com.arangodb.springframework.annotation.Param;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import it.unimib.disco.asia.backend.model.Event;

import java.util.Date;

public interface EventRepository extends ArangoRepository<Event> {

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
	Iterable<Event> eventWithCategoriesQuery(@Param("geoIds") String[] ids,
							   @Param("dates") Date[] dates,
							   @Param("catIds") String[] categories);

	@Query("let isoDates = (for d in @dates return DATE_FORMAT(DATE_ISO8601(d), \"%yyyy-%mm-%dd\"))\n" +
			"\t\t\tfor event in `events`\n" +
			"\t\t\tFILTER  event.info.eventDate IN isoDates\n" +
			"\t\t\t    and event.info.location.geoNamesId IN @geoIds\n" +
			"\t\t\t    collect location = event.info.location.geoNamesId,\n" +
			"\t\t\t            date = event.info.eventDate\n" +
			"\t\t\t            with count into eventsCount\n" +
			"\t\t\t    return {'geonamesId': location,\n" +
			"\t\t\t        'eventDate': date,\n" +
			"\t\t\t        'eventsCount': eventsCount\n" +
			"\t\t\t        }")
	Iterable<Event> eventQuery(@Param("geoIds") String[] ids,
							   @Param("dates") Date[] dates);
}
