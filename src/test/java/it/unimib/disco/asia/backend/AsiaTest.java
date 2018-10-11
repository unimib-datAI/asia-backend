package it.unimib.disco.asia.backend;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.net.URLEncoder;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // loads server.port from config file
public class AsiaTest {

    private static final String asiaEndpoint = "http://localhost:7000/";

    private String reconcile(String label, String type, double threshold, String conciliator) {
        try {
            String query = (type == null || type.isEmpty()) ?
                    String.format("{\"q0\": {\"query\": \"%s\"}}", label) :
                    String.format("{\"q0\": {\"query\": \"%s\",  \"type\":\"%s\", \"type_strict\":\"should\"}}", label, type);

            String url = String.format("%sreconcile?queries=%s&conciliator=%s",
                    asiaEndpoint, URLEncoder.encode(query, "UTF-8"), conciliator);

            JsonNode results = new ObjectMapper().readTree(new URL(url)).get("q0").get("result");
            if (results.get(0).get("score").asDouble() >= threshold) {
                return results.get(0).get("id").asText();
            }
        } catch (Exception ignored) { }

        return "";
    }

    private String extend(String id, String property, String conciliator) {
        try {
            String query = String.format("{\"ids\":[\"%s\"],\"properties\":[{\"id\":\"%s\"}]}", id, property);
            String url = String.format("%sextend?extend=%s&conciliator=%s",
                    asiaEndpoint, URLEncoder.encode(query, "UTF-8"), conciliator);

            return new ObjectMapper().readTree(new URL(url)).get("rows").get(id).get(property).get(0).get("id").asText();
        } catch (Exception ignored) { }

        return "";
    }

    private String extendWeather(String id, String date, String aggregator, String weatherParam, String offset) {
        try {
            String url = String.format("%sweather?ids=%s&dates=%s&aggregators=%s&weatherParams=%s&offsets=%s",
                    asiaEndpoint, id, date, aggregator, weatherParam, offset);
            JsonNode value = new ObjectMapper().readTree(new URL(url)).get(0).get("weatherParameters").get(0).get("value");
            if (!value.isNull()) {
                return value.asText();
            }
        } catch (Exception ignored) { }

        return "";
    }


    @Test
    public void testReconciliation() {
        // Empty results -> empty string
        assertEquals("", reconcile("fake", "A.ADM1", 1.0, "geonames"));
        // No type -> some results -> keep first (1003854)
        assertEquals("1003854", reconcile("Berlin", null, 1.0, "geotargets"));
        // Empty type -> some results -> keep first (same as before)
        assertEquals("1003854", reconcile("Berlin", "", 1.0, "geotargets"));
        // Some results -> keep first -> score lower than threshold (0.7393162393162394) -> empty string
        assertEquals("", reconcile("berlin", "A.ADM3", 0.8, "geonames"));
        // Some results -> keep first -> score greater than threshold (0.7393162393162394) -> return
        assertEquals("6547383", reconcile("berlin", "A.ADM3", 0.4, "geonames"));
    }

    @Test
    public void testExtension() {
        // Fake city -> empty string
        assertEquals("", extend("fake", "parentADM1", "geonames"));
        // Valid parentADM1
        assertEquals("2953481", extend("6557964", "parentADM1", "geonames"));
        // Valid city, but no parentADM2 available -> empty string
        assertEquals("", extend("3207710", "parentADM2", "geonames"));
    }

    @Test
    public void testWeather() {
        // Fake date -> empty string
        assertEquals("", extendWeather("2953481", "fake", null, "2t", "1"));
        // Fake weatherParam -> empty string
        assertEquals("", extendWeather("2953481", "2018-07-25", null, "fake", "1"));
        // Valid example -> get temperature (294.006742227)
        assertEquals("294.006742227", extendWeather("2953481", "2018-07-25", null, "2t", "1"));
    }

}
