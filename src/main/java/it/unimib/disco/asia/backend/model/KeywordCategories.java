package it.unimib.disco.asia.backend.model;


import java.util.List;


public class KeywordCategories {


    private String keyword;
    private List<String> categories;

    public KeywordCategories() {
    }

    public KeywordCategories(String keyword, List<String> categories) {
        this.keyword = keyword;
        this.categories = categories;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
