package it.unimib.disco.asia.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.disco.asia.backend.config.ConciliatorConfig;
import it.unimib.disco.asia.backend.config.VirtuosoConfig;
import it.unimib.disco.asia.backend.response.*;
import org.apache.jena.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExactMatch {

    @Autowired
    VirtuosoConfig virtuosoConfig;

    @Autowired
    ConciliatorConfig conciliatorConfig;

    @RequestMapping(value = "exactMatch", produces = "application/json")
    public MatchResult<String> getExactMatch(@RequestParam(value = "ids") String idsList,
                                     @RequestParam(value = "source") String source,
                                     @RequestParam(value = "target") String target) throws Exception {

        Conciliator sourceConciliator = this.getServiceMetadata(source);

        String matchProp = String.format("%s%s2%s", virtuosoConfig.getMatchPropertyPrefix(), source, target);

        String[] geoIdsStr = idsList.split(",");

        Map<String, String> uriToId = new HashMap<>();
        MatchResult<String> matchResult = new MatchResult<>();

        MatchMetaData mmd = new MatchMetaData();
        mmd.setId(matchProp);
        mmd.setName(matchProp.substring(matchProp.lastIndexOf("/") + 1));

        matchResult.setMeta(mmd);
        matchResult.setRows(new HashMap<>());

        for (String geoId: geoIdsStr) {
            MatchList<String> matchList = new MatchList<>();
            matchList.put(matchProp, new ArrayList<>());
            matchResult.getRows().put(geoId, matchList);

            String geoIdUri = String.format("%s%s", sourceConciliator.getIdentifierSpace(), geoId);
            uriToId.put(String.format("<%s>", geoIdUri), geoId);
            uriToId.put(String.format("<%s/>", geoIdUri), geoId); // Some URIs end with /
        }

        String queryString = String.format(
                "SELECT ?source ?prop ?target\n" +
                        "WHERE\n" +
                        "{\n" +
                        "  ?source <%s> ?target .\n" +
                        "  VALUES ?source { %s }\n" +
                        "}",
                matchProp, String.join(" ", uriToId.keySet()));

        Query sparqlQuery = QueryFactory.create(queryString);

        try (QueryExecution qexec = QueryExecutionFactory.sparqlService(virtuosoConfig.getEndpoint(), sparqlQuery, virtuosoConfig.getGraphName())) {
            ResultSet sparqlResults = qexec.execSelect();
            while (sparqlResults.hasNext()) {
                QuerySolution soln = sparqlResults.nextSolution();
                matchResult.getRows()
                        .get(uriToId.get(String.format("<%s>", soln.getResource("source").getURI())))
                        .get(matchProp)
                        .add(new Match(soln.getResource("target").getURI()));
            }
        } catch (Exception e) {
            return null;
        }

        return matchResult;
    }

    private Conciliator getServiceMetadata(String conciliatorId) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Conciliator c = new Conciliator(conciliatorId);

        JsonNode root = mapper.readTree(new URL(conciliatorConfig.getEndpoint() + c.getId()));
        c.setName(root.get("name").asText());
        c.setIdentifierSpace(root.get("identifierSpace").asText());
        c.setSchemaSpace(root.get("schemaSpace").asText());

        return c;
    }

}
