package com.example.leona.news_app.utilities;

import android.net.Uri;
import android.util.Log;

import com.example.leona.news_app.model.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static android.content.ContentValues.TAG;

/**
 * Created by leona on 6/18/2017.
 */

public class NetworkUtils {

    //Define the appropriate base_url and query_parameter constants
    // (make sure they are Java constants) here as static class members.
    //5. 5pts: Create a static method in NetworkUtils that uses Uri.Builder to build the appropriate url,
    // the url you used in (2), to return a completed Java URL.
    private static final String NEWS_BASE_URL = "https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&";
    private static final String queryApiKey= "apiKey";


    //******************


    public static URL makeUrl() {
        //build the url to were well retrive info
        Uri builtUri = Uri.parse(NEWS_BASE_URL).buildUpon()
                .appendQueryParameter(queryApiKey,"a09dde5b2a7f45e0989769b4afefe45b")
                .build();

        URL url = null;

        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }

    //6. 2pts: Put this method in your NetworkUtils class:

    public static String getResponseFromHttpUrl(URL url) throws IOException
    {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try{
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            if(hasInput)
            {
                return scanner.next();
            }
            else {
                return null;
            }

        }
        finally {
            urlConnection.disconnect();
        }
    }



    public static ArrayList<NewsItem> parseJSON(String json) throws JSONException {
        ArrayList<NewsItem> output = new ArrayList<>();

        JSONObject main = new JSONObject(json);

        JSONArray articles = main.getJSONArray("articles");

        for(int i = 0; i < articles.length(); i++){
            JSONObject article = articles.getJSONObject(i);

            String title = article.getString("title");
            String description = article.getString("description");
            String url = article.getString("url");
            String urlToImage = article.getString("urlToImage");
            String author = article.getString("author");
            String publishedAt = article.getString("publishedAt");

            NewsItem item = new NewsItem(url,urlToImage,publishedAt,author,title,description);
            output.add(item);
        }

        return output;
    }





}


