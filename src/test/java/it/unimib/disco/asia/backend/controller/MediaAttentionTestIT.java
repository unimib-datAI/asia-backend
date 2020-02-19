package it.unimib.disco.asia.backend.controller;

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

    @Before
    public void setupForTest() {

        RestAssured.port = port;
        System.out.println(RestAssured.port);
        RestAssured.baseURI = "http://localhost";
    }


    @Test
    public void postMediaAttentionRequest() throws JSONException {

        MediaAttentionRequest request = new MediaAttentionRequest();
        request.setCategories(Arrays.asList("football", "music"));
        request.setDates(Arrays.asList("20170201", "2017-02-03"));
        request.setForecast_offset(-1);
        request.setFeatures(Arrays.asList("EventsCounts", "ArticlesCounts"));

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request)
                .post("mediaattention/enrich");


        System.out.println(response.body().asString());
        String mystr = "[{\"data\":[{\"EventsCounts\":21.0,\"ArticlesCounts\":89.0,\"EventsCountsPastAvg\":18.285714285714285,\"ArticlesCountsPastAvg\":72.71428571428571,\"EventsCountsPastMin\":12.0,\"EventsCountsPastMax\":27.0,\"ArticlesCountsPastMax\":89.0,\"ArticlesCountsPastMin\":49.0},{\"EventsCounts\":18.0,\"ArticlesCounts\":104.0,\"EventsCountsPastAvg\":18.285714285714285,\"ArticlesCountsPastAvg\":79.14285714285714,\"EventsCountsPastMin\":12.0,\"EventsCountsPastMax\":28.0,\"ArticlesCountsPastMax\":104.0,\"ArticlesCountsPastMin\":49.0}],\"category\":\"football\"},{\"data\":null,\"category\":\"music\"}]";

        JSONAssert.assertEquals(mystr, response.body().asString(), false);

    }
}