package it.unimib.disco.asia.backend.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import it.unimib.disco.asia.backend.model.customevent.CustomEvent;

public interface CustomEventRepository extends ArangoRepository<CustomEvent> {

//    @Query("for event in #collection\n" +
//            "FILTER event._id IN @ids" +
//            "RETURN {"
//            "for field in @field" +
//            " FILTER event[field] ==  "
//
//            "\t\t\tFILTER  event.info.eventDate IN isoDates\n" +
//            "\t\t\t    and event.info.location.geoNamesId IN @geoIds\n" +
//            "\t\t\t    collect location = event.info.location.geoNamesId,\n" +
//            "\t\t\t            date = event.info.eventDate\n" +
//            "\t\t\t            with count into eventsCount\n" +
//            "\t\t\t    return {'geonamesId': location,\n" +
//            "\t\t\t        'eventDate': date,\n" +
//            "\t\t\t        'eventsCount': eventsCount\n" +
//            "\t\t\t        }")
//    Iterable<Event> eventQuery(@BindVars String[] ids,
//                               @Param("dates") Date[] dates);
//
//
//    @Query("FOR c IN #collection FILTER c[@field] == @value RETURN c")
//    @QueryOptions(cache = true, ttl = 128)
//    ArangoCursor<Customer> query(@BindVars  Map<String, Object> bindVars, AqlQueryOptions options);
//

}
