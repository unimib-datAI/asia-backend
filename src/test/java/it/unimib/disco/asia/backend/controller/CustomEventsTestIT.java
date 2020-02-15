package it.unimib.disco.asia.backend.controller;

import com.arangodb.ArangoCursor;
import com.arangodb.model.AqlQueryOptions;
import com.arangodb.springframework.core.ArangoOperations;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import it.unimib.disco.asia.backend.model.customevent.CustomEvent;
import it.unimib.disco.asia.backend.model.customevent.CustomEventLogicBaseUnit;
import it.unimib.disco.asia.backend.repository.CustomEventRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "arango.host=localhost",
                "arango.db-name=events",
                "arango.port=8529",
                "arango.password=openSesame",
                "arango.username=root"})
public class CustomEventsTestIT {

    @ClassRule
    public static DockerComposeContainer compose =
            new DockerComposeContainer(
                    new File("src/test/docker/CustomEventsTestIT/docker-compose_arango.yml"))
                    .withLocalCompose(true);
    String customEventStr1 = "{\"@type\":\"ews:Event\",\"identifier\":\"eventPilot1\",\"name\":{\"text\":\"Price change\",\"lang\":\"en\"},\"startDate\":\"2019-05-14\",\"category\":{\"@type\":\"ews:Category\",\"identifier\":\"964\"},\"product\":{\"@type\":\"ews:Product\",\"identifier\":\"9577242\",\"gtin13\":\"8718863014653\",\"description\":\"PHILIPS LED TV 22PFS5403/12\",\"sku\":\"9577242\",\"seller\":{\"@type\":\"ews:Seller\",\"identifier\":\"1335\"}},\"measure\":{\"@type\":\"ews:Measure\",\"priceChanged\":true,\"priceChange\":2.98,\"price\":136.57}}";
    String customEventStr2 = "{\"@type\":\"ews:Event\",\"identifier\":\"eventPilot1\",\"name\":{\"text\":\"Price change\",\"lang\":\"en\"},\"startDate\":\"2019-05-14\",\"category\":{\"@type\":\"ews:Category\",\"identifier\":\"964\"},\"product\":{\"@type\":\"ews:Product\",\"identifier\":\"12429022\",\"gtin13\":\"8801643703257\",\"description\":\"SAMSUNG LED TV UE55RU7102KXXH\",\"sku\":\"12429022\",\"seller\":{\"@type\":\"ews:Seller\",\"identifier\":\"1335\"}},\"measure\":{\"@type\":\"ews:Measure\",\"priceChanged\":true,\"priceChange\":29.7,\"price\":593.85}}";
    @LocalServerPort
    private int port;

    @Autowired
    private CustomEventRepository customEventRepository;
    @Autowired
    private ArangoOperations template;
    private ObjectMapper objectMapper;

    @Before
    public void setupForTest() {

        RestAssured.port = port;
        System.out.println(RestAssured.port);
        RestAssured.baseURI = "http://localhost";
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    //    @Test
    public void checkRepositoryAndArango() throws IOException {
        customEventRepository.deleteAll();

        CustomEvent customEvent = objectMapper.readValue(customEventStr1, CustomEvent.class);

        System.out.println(customEvent.getAtType());

        CustomEvent savedEvent = customEventRepository.save(customEvent);

        Map<String, Object> map = new HashMap<>();
        map.put("ident", "eventPilot1");

        ArangoCursor<String> returnedEvent =
                template.query("FOR i IN CustomEvents FILTER i.identifier == @ident  RETURN i",
                        map,
                        new AqlQueryOptions(), String.class);

        CustomEvent returnedCustomEvent = objectMapper.readValue(returnedEvent.next(), CustomEvent.class);
        MatcherAssert.assertThat(returnedCustomEvent.getStartDate(), Matchers.equalTo(savedEvent.getStartDate()));
    }


    @Test
    public void testController1() throws IOException {

        customEventRepository.deleteAll();

        CustomEvent customEvent1 = objectMapper.readValue(customEventStr1, CustomEvent.class);
        CustomEvent customEvent2 = objectMapper.readValue(customEventStr2, CustomEvent.class);


        CustomEvent savedEvent1 = customEventRepository.save(customEvent1);
        CustomEvent savedEvent2 = customEventRepository.save(customEvent2);


        List<List<CustomEventLogicBaseUnit>> lst = objectMapper.readValue(new File("src/test/resources/CustomEventsTestIT/JSON.txt"),
                new TypeReference<List<List<CustomEventLogicBaseUnit>>>() {
                });

        System.out.println(lst.get(0).get(0).getOperator());

        List<List<CustomEventLogicBaseUnit>> sublist = lst.subList(0, 2);

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(sublist)
                .get("customevents/match");


        String s1 = response.getBody().asString();
        String replace = s1.replace("[", "");
        String replace1 = replace.replace(" ", "");
        String replace2 = replace1.replace("]", "");

        List<String> myList = new ArrayList<String>(Arrays.asList(replace2.split(",")));

        System.out.println(myList.toString());
        assertThat(myList.contains(savedEvent1.get_id()), Matchers.is(true));
        assertThat(myList.contains(savedEvent2.get_id()), Matchers.is(true));
    }


    @Test
    public void testController2() throws IOException {

        customEventRepository.deleteAll();

        CustomEvent customEvent1 = objectMapper.readValue(customEventStr1, CustomEvent.class);
        CustomEvent customEvent2 = objectMapper.readValue(customEventStr2, CustomEvent.class);


        CustomEvent savedEvent1 = customEventRepository.save(customEvent1);
        CustomEvent savedEvent2 = customEventRepository.save(customEvent2);


        String ids = savedEvent1.get_id() + "," + savedEvent2.get_id();

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .param("ids", ids)
                .param("propIds", "measure.priceChanged,product.gtin13")
                .get("customevents/select");


        response.getBody().prettyPrint();
        List<Map<String, String>> lst = response.jsonPath().getList("$");

        assertThat(lst.size(), Matchers.is(2));
        assertThat(lst.get(0).containsKey("measure.priceChanged"), Matchers.is(true));


        String mystr = "[{\"id\": \"" + savedEvent1.get_id() + "\",\"measure.priceChanged\": true,\"product.gtin13\": \"8718863014653\"" +
                "    },{\"id\": \"" + savedEvent2.get_id() + "\"," +
                "        \"measure.priceChanged\": true," +
                "        \"product.gtin13\": \"8801643703257\"" +
                "    }" +
                "]";
        assertThat(
                response.jsonPath().prettyPrint(),
                sameJSONAs(mystr)
                        .allowingExtraUnexpectedFields()
                        .allowingAnyArrayOrdering());


    }

}
