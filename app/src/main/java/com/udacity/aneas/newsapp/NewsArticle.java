package com.udacity.aneas.newsapp;

/**
 * Created by Aneas on 2/13/2017.
 */

public class NewsArticle {

    private String mArticleSection;
    private String mWebUrl;
    private String mArticleTitle;

    public NewsArticle(String articleSection, String webUrl, String articleTitle) {
        mArticleSection = articleSection;
        mWebUrl = webUrl;
        mArticleTitle = articleTitle;
    }

    public String getArticleSection() {
        return mArticleSection;
    }

    public String getWebUrl() {
        return mWebUrl;
    }

    public String getArticleTitle() {
        return mArticleTitle;
    }
}
