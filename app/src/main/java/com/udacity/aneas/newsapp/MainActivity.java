package com.udacity.aneas.newsapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsArticle>> {
private List<NewsArticle> mNewsArticles = new ArrayList<>();
    private RecyclerView.Adapter myAdapter = new NewsRecyclerView(getBaseContext());
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        mRecyclerView.setLayoutManager(layoutManager);

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(0, null, this);

    }

    @Override
    public Loader<List<NewsArticle>> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(getBaseContext());
    }

    @Override
    public void onLoadFinished(Loader<List<NewsArticle>> loader, List<NewsArticle> newsArticles) {
        mRecyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<NewsArticle>> loader) {
mRecyclerView.invalidate();
    }
}
