package it.unimib.disco.asia.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.disco.asia.backend.config.ConciliatorConfig;
import it.unimib.disco.asia.backend.config.VirtuosoConfig;
import it.unimib.disco.asia.backend.model.Service;
import it.unimib.disco.asia.backend.response.*;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ExactMatch {

    @Autowired
    VirtuosoConfig virtuosoConfig;

    @Autowired
    ConciliatorConfig conciliatorConfig;

    private final String MATCH_PROPERTY_ID = "http://www.w3.org/2004/02/skos/core#exactMatch";
    private final String MATCH_PROPERTY_NAME = "exactMatch";

    @RequestMapping(value = "exactMatch", produces = "application/json")
    public MatchResult<String> getGeoExactMatch(@RequestParam(value = "ids") String idsList,
                                     @RequestParam(value = "source") String source,
                                     @RequestParam(value = "target") String target) throws Exception {

        Conciliator sourceConciliator = this.getServiceMetadata(source);
        Conciliator targetConciliator = this.getServiceMetadata(target);

        String matchProp;

        // Assumption: all KBs are linked to GeoNames (star model)
        if (source.equalsIgnoreCase(Service.GEONAMES.getId()) || target.equalsIgnoreCase(Service.GEONAMES.getId())) {
            matchProp = String.format(":%s2%s", source, target);
        } else {
            matchProp = String.format(":%s2geonames/:geonames2%s", source, target);
        }

        String[] geoIdsStr = idsList.split(",");

        Map<String, String> uriToId = new HashMap<>();
        MatchResult<String> matchResult = new MatchResult<>();

        MatchMetaData mmd = new MatchMetaData();
        mmd.setId(this.MATCH_PROPERTY_ID);
        mmd.setName(this.MATCH_PROPERTY_NAME);

        matchResult.setMeta(mmd);
        matchResult.setRows(new HashMap<>());

        for (String geoId: geoIdsStr) {
            MatchList<String> matchList = new MatchList<>();
            matchList.put(this.MATCH_PROPERTY_NAME, new ArrayList<>());
            matchResult.getRows().put(geoId, matchList);

            String geoIdUri = String.format("%s%s", sourceConciliator.getIdentifierSpace(), geoId);
            uriToId.put(String.format("<%s>", geoIdUri), geoId);
            uriToId.put(String.format("<%s/>", geoIdUri), geoId); // Some URIs end with /
        }

        String queryString = String.format(
                "DEFINE input:inference '%s'\n" +
                        "PREFIX : <%s>\n" +
                        "SELECT ?source ?target\n" +
                        "FROM <%s>\n" +
                        "WHERE\n" +
                        "{\n" +
                        "  ?source %s ?target .\n" +
                        "  VALUES ?source { %s }\n" +
                        "}",
                virtuosoConfig.getGeoGraph().getRulesSetName(),
                virtuosoConfig.getGeoGraph().getMatchPropertyPrefix(),
                virtuosoConfig.getGeoGraph().getGraphName(),
                matchProp,
                String.join(" ", uriToId.keySet()));

        try (QueryEngineHTTP request = new QueryEngineHTTP(
                virtuosoConfig.getEndpoint(),
                queryString)) {
            ResultSet sparqlResults = request.execSelect();
            while (sparqlResults.hasNext()) {
                QuerySolution soln = sparqlResults.nextSolution();
                matchResult.getRows()
                        .get(uriToId.get(String.format("<%s>", soln.getResource("source").getURI())))
                        .get(this.MATCH_PROPERTY_NAME)
                        .add(new Match(soln.getResource("target").getURI().replaceAll(targetConciliator.getIdentifierSpace(), "")));
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
