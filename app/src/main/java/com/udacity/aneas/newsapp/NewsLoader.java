package com.udacity.aneas.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aneas on 2/13/2017.
 */

public class NewsLoader extends AsyncTaskLoader<List<NewsArticle>> {
    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    public List<NewsArticle> loadInBackground() {
        Utility.fetchNewsArticles("http://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test");
        ArrayList<NewsArticle> mine = new ArrayList<>();
        return null;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
