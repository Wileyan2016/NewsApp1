package com.udacity.aneas.newsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aneas on 2/17/2017.
 */

public class NewsRecyclerView extends RecyclerView.Adapter<NewsRecyclerView.ViewHolder> {
    private List<NewsArticle> mNewsArticles = new ArrayList<>();
    private Context mContext;

    public Context getContext() {
        return mContext;
    }

    public NewsRecyclerView(Context context) {

        mContext = context;
    }

    //Holder for Views in RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mArticleSection;
        TextView mArticleTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mArticleSection = (TextView) itemView.findViewById(R.id.newssection);
            mArticleTitle = (TextView) itemView.findViewById(R.id.newsArticleTitle);

        }


    }

    @Override
    public NewsRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //inflate the custom layout
        View currentView = inflater.inflate(R.layout.recycleviewlist_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(currentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsRecyclerView.ViewHolder holder, int position) {
        //Get the current Article you are working on from array above
        NewsArticle article = mNewsArticles.get(position);
//Retrieve your TextView from your Viewholder Object and set the textview associated with current holder object
        TextView articleName = holder.mArticleTitle;
        articleName.setText(article.getArticleTitle());
        TextView sectionTitle = holder.mArticleSection;
        sectionTitle.setText(article.getArticleSection());
    }

    @Override
    public int getItemCount() {
        return mNewsArticles.size();
    }
}
