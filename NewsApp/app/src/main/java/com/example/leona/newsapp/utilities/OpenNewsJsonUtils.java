package com.example.leona.newsapp.utilities;

import android.content.ContentValues;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

/**
 * Created by leona on 6/20/2017.
 */

public class OpenNewsJsonUtils {
    /**
     * This method parses JSON from a web response and returns an array of Strings
     * describing the weather over various days from the forecast.
     * <p/>
     * Later on, we'll be parsing the JSON into structured data within the
     * getFullWeatherDataFromJson function, leveraging the data we have stored in the JSON. For
     * now, we just convert the JSON into human-readable strings.
     *
     * @param newsJsonStr JSON response from server
     *
     * @return Array of Strings describing weather data
     *
     * @throws JSONException If JSON data cannot be properly parsed
     */
    public static String[] getSimpleNewsStringsFromJson(Context context,    String newsJsonStr)
            throws JSONException {

        final String news_articles = "articles";
        final String news_author = "author";
        final String news_title = "title";
        final String news_desc = "description";
        final String news_url = "url";
        final String news_image = "urlToImage";
        final String news_published_at = "publishedAt";

        String[] parsedNewsData = null;

        JSONObject newsJson = new JSONObject(newsJsonStr);

        if(newsJson.has("status")){
            String status = newsJson.getString("status");

            switch(status){
                case "ok":
                    break;
                default:
                    return null;
            }
        }

        JSONArray newsArray = newsJson.getJSONArray(news_articles);
        parsedNewsData = new String[newsArray.length()];

        for(int i = 0; i<newsArray.length(); i++){
            //these need to be  fixed
            String title;
            String desc;
            String author;
            String url;
            String image;
            String published;

            JSONObject article = newsArray.getJSONObject(i);

            title = article.getString(news_title);
            desc = article.getString(news_desc);
            author = article.getString(news_author);
            url = article.getString(news_url);
            image = article.getString(news_image);
            published = article.getString(news_published_at);

            parsedNewsData[i] = "Title:  "+title+" \n\n Author:  "+author+" \n\n Published At:  "+published+" \n\n Url:  "+url+" \n\n Description:  "+desc;
        }

        return parsedNewsData;
    }
}
