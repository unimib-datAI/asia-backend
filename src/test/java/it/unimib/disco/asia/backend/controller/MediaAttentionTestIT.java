package it.unimib.disco.asia.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import it.unimib.disco.asia.backend.model.MediaAttentionRequest;
import org.json.JSONException;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"media.attention.host=http://localhost", "media.attention.port=1338"})
public class MediaAttentionTestIT {

    @ClassRule
    public static DockerComposeContainer compose =
            new DockerComposeContainer(
                    new File("src/test/docker/MediaAttentionTestIT/docker-compose.yml")).withLocalCompose(true);
    @LocalServerPort
    private int port;
    private ObjectMapper objectMapper;

    @Before
    public void setupForTest() {

        RestAssured.port = port;
        System.out.println(RestAssured.port);
        RestAssured.baseURI = "http://localhost";
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Test
    public void postMediaAttentionRequest() throws JSONException, JsonProcessingException {

        MediaAttentionRequest request = new MediaAttentionRequest();
        request.setCategories(Arrays.asList("football", "music", "home"));
        request.setDates(Arrays.asList("20170201", "2017-02-03"));
        request.setForecast_offset(-1);
        request.setFeatures(Arrays.asList("EventsCounts", "ArticlesCounts"));

        System.out.println(objectMapper.writeValueAsString(request));


        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request)
                .post("mediaattention/enrich");


        System.out.println(response.body().asString());
        String mystr = "[{\"data\":[{\"EventsCounts\":21.0,\"ArticlesCounts\":89.0,\"EventsCountsPastAvg\":18.285714285714285,\"ArticlesCountsPastAvg\":72.71428571428571,\"EventsCountsPastMin\":12.0,\"EventsCountsPastMax\":27.0,\"ArticlesCountsPastMax\":89.0,\"ArticlesCountsPastMin\":49.0}," +
                "{\"EventsCounts\":18.0,\"ArticlesCounts\":104.0,\"EventsCountsPastAvg\":18.285714285714285,\"ArticlesCountsPastAvg\":79.14285714285714,\"EventsCountsPastMin\":12.0,\"EventsCountsPastMax\":28.0,\"ArticlesCountsPastMax\":104.0,\"ArticlesCountsPastMin\":49.0}],\"category\":\"football\"}," +
                "{\"data\":[{\"EventsCounts\":0.0,\"ArticlesCounts\":6.0,\"EventsCountsPastAvg\":0.0,\"ArticlesCountsPastAvg\":4.857142857142857,\"EventsCountsPastMin\":0.0,\"EventsCountsPastMax\":0.0,\"ArticlesCountsPastMax\":9.0,\"ArticlesCountsPastMin\":1.0}," +
                "{\"EventsCounts\":0.0,\"ArticlesCounts\":1.0,\"EventsCountsPastAvg\":0.0,\"ArticlesCountsPastAvg\":5.714285714285714,\"EventsCountsPastMin\":0.0,\"EventsCountsPastMax\":0.0,\"ArticlesCountsPastMax\":13.0,\"ArticlesCountsPastMin\":1.0}],\"category\":\"music\"}," +
                "{\"data\":null,\"category\":\"home\"}]";

        JSONAssert.assertEquals(mystr, response.body().asString(), false);

    }
}