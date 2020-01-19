package it.unimib.disco.asia.backend.controller;

import it.unimib.disco.asia.backend.connectors.Key2ClusterConnector;
import it.unimib.disco.asia.backend.model.KeywordCategories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryClusters {

    private final Key2ClusterConnector connector;

    public CategoryClusters(Key2ClusterConnector connector) {
        this.connector = connector;
    }

    @RequestMapping(value = "keywordscategories", produces = "application/json")
    public List<KeywordCategories> getWeather(@RequestParam(value = "kws") String keywords) throws Exception {
        //as input we get comma-separated keywords
        return connector.getCategoriesForMultiKeywords(keywords);

    }


}
