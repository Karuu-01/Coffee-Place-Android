package com.moringaschool.newsapp.models;

import java.util.ArrayList;

public class MainNews {

    private String status;
    private String totalResults;
    private ArrayList<ArticleNews> articles;

    public MainNews(String status, String totalResults, ArrayList<ArticleNews> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ArticleNews> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticleNews> articles) {
        this.articles = articles;
    }
}
