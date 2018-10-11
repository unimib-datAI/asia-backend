package it.unimib.disco.asia.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import it.unimib.disco.asia.backend.response.ConciliatorResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MasterTest {

    @TestConfiguration
    static class TestConfig {
        // Put ad-hoc config here
    }

    @Autowired
    MockMvc mvc;

    @Autowired
    Master master;

    private String reconcileMvc(String queries, String conciliator) throws Exception {
        return mvc.perform(get("/reconcile")
                .param("queries", queries)
                .param("conciliator", conciliator)
        ).andReturn().getResponse().getContentAsString();
    }

    private JsonNode reconcileMethod(String queries, String conciliator) throws Exception {
        return master.reconcile(queries, conciliator);
    }

    private JsonNode extendMethod(String queries, String conciliator) throws Exception {
        return master.extend(queries, conciliator);
    }

    private Map<String, List<ConciliatorResult>> suggestMethod(String queries, String group) throws Exception {
        return master.suggest(queries, group);
    }

    @Test
    public void testReconcile() throws Exception {

        String reconcileQueries = "{\"q0\": {\"query\": \"Steinheim an der Murr\"}," +
                "\"q1\": {\"query\": \"Mainz\"}," +
                "\"q2\": {\"query\": \"Finsterwalde\"}," +
                "\"q3\": {\"query\": \"Stuttgart\"}," +
                "\"q4\": {\"query\": \"Marktredwitz\"}," +
                "\"q5\": {\"query\": \"Wuppertal\"}," +
                "\"q6\": {\"query\": \"Berlin\"}}";

        String conciliator = "geonames";

        String bodyHttp = this.reconcileMvc(reconcileQueries, conciliator);
        JsonNode bodyMethod = this.reconcileMethod(reconcileQueries ,conciliator);

        assertEquals(bodyHttp, bodyMethod.toString());

        JsonNode results = bodyMethod.get("q0").get("result");

        assertEquals(2, results.size());

        JsonNode result1 = results.get(0);
        assertEquals("Steinheim an der Murr", result1.get("name").asText());
        assertEquals("6557964", result1.get("id").asText());
        assertEquals("1.0", result1.get("score").asText());

        JsonNode result2 = results.get(1);
        assertEquals("Steinheim am der Murr", result2.get("name").asText());
        assertEquals("2827988", result2.get("id").asText());
        assertEquals("1.0", result2.get("score").asText());
    }

    @Test
    public void testExtend() throws Exception {
        // 10 ids, 2 properties
        String extendQueries = "{\"ids\":[\"6557964\",\"6554818\",\"6550600\",\"6690189\",\"6558332\",\"6553031\"," +
                "\"6547539\",\"6550942\",\"6557443\",\"6554251\"]," +
                "\"properties\":[{\"id\":\"parentADM1\"},{\"id\":\"parentADM2\"}]}";

        String conciliator = "geonames";

        JsonNode result = this.extendMethod(extendQueries,conciliator);

        JsonNode rows = result.get("rows");
        JsonNode meta = result.get("meta");

        assertEquals(10, rows.size()); // 10 ids
        assertEquals(2, meta.size());  // 2 props
    }
}
