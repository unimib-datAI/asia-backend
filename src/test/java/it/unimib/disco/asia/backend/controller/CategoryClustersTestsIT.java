package it.unimib.disco.asia.backend.controller;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import it.unimib.disco.asia.backend.config.KeywordClusterConfig;
import it.unimib.disco.asia.backend.model.KeywordCategories;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"keyword.cluster.service.host=http://localhost", "keyword.cluster.service.port=8081"})
public class CategoryClustersTestsIT {

    @ClassRule
    public static DockerComposeContainer compose =
            new DockerComposeContainer(
                    new File("src/test/docker/docker-compose.yml")).withLocalCompose(true);
    @Autowired
    private KeywordClusterConfig config;
    @LocalServerPort
    private int port;
    private String baseURI;

    @Before
    public void setupForTest() {

        RestAssured.port = port;
        System.out.println(RestAssured.port);
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void getCategoriesPerKeyword() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .param("kws", "11 28 cassette,ciao")
                .get("keywordscategories");


        response.getBody().prettyPrint();
        KeywordCategories[] kc = response.then().assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(KeywordCategories[].class);
        assertThat(kc[0].getCategories().size(), Matchers.is(1));
        assertThat(kc[0].getCategories(), Matchers.contains("/Ocasiones y regalos/Vacaciones y eventos estacionales/Halloween y 31 de octubre(13740)"));

        Response response2 = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .param("kws", "casa,home")
                .get("keywordscategories");

        response2.getBody().prettyPrint();


    }


}
