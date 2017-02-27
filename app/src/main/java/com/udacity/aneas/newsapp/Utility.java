package com.udacity.aneas.newsapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aneas on 2/13/2017.
 */

public class Utility {


    public static List<NewsArticle> fetchNewsArticles(String url) {
        List<NewsArticle> fetchedNews = new ArrayList<>();
        HttpURLConnection mURLConnection;
        InputStream inputStream;
        String jsonResponse = "";

        if (url.isEmpty() || url == null) {
            return null;
        } else {
            URL url1 = createURL(url);
            try {
                mURLConnection = (HttpURLConnection) url1.openConnection();
                mURLConnection.setRequestMethod("GET");
                mURLConnection.setReadTimeout(10000);
                mURLConnection.setConnectTimeout(15000);
                mURLConnection.connect();
                if (mURLConnection.getResponseCode() == 200) {
                    inputStream = mURLConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                    fetchedNews = readJsonData(jsonResponse);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return fetchedNews;
    }

    private static URL createURL(String url) {
        URL urlToBeCreated = null;
        try {
            urlToBeCreated = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlToBeCreated;
    }


    static String readFromStream(InputStream inputStream) {
        StringBuilder output = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        BufferedReader reader = new BufferedReader(isr);
        try {
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }


    static List<NewsArticle> readJsonData(String inputStreamData) {
        List<NewsArticle> newsArticles = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(inputStreamData);
            JSONObject response = root.getJSONObject("response");
            JSONArray resultsArray = response.getJSONArray("results");
            for (int a = 0; a < resultsArray.length(); a++) {
                JSONObject currentArticle = resultsArray.getJSONObject(a);
                String weburl = currentArticle.getString("webUrl");
                String articleTitle = currentArticle.getString("webTitle");
                String articleSection = currentArticle.getString("sectionName");
                newsArticles.add(new NewsArticle(articleSection, weburl, articleTitle));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return newsArticles;
    }

}

