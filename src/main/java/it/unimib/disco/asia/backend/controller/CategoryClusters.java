package it.unimib.disco.asia.backend.controller;

import it.unimib.disco.asia.backend.connectors.Key2ClusterConnector;
import it.unimib.disco.asia.backend.model.KeywordCategories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryClusters {

    private final Key2ClusterConnector connector;

    public CategoryClusters(Key2ClusterConnector connector) {
        this.connector = connector;
    }

    private KeywordCategories limit(KeywordCategories keywordCategories, int limit) {
        if (limit < keywordCategories.getCategories().size()) {
            keywordCategories.setCategories(keywordCategories.getCategories().subList(0, limit));
        }
        return keywordCategories;
    }

    @RequestMapping(value = "keywordscategories", produces = "application/json;charset=UTF-8")
    public List<KeywordCategories> getCategories(@RequestParam(value = "kws") String keywords,
                                                 @RequestParam(defaultValue = "10") String limit) {
        int lim = 10;
        try {
            lim = Integer.parseInt(limit);
        } catch (Exception ignored) { }

        List<KeywordCategories> res = connector.getCategoriesForMultiKeywords(keywords);
        if (lim > 0) {
            int finalLim = lim;
            return res.stream().map(keywordCategories -> this.limit(keywordCategories, finalLim)).collect(Collectors.toList());
        }
        return res;
    }

}
