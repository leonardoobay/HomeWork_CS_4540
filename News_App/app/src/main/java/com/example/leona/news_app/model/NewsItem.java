package com.example.leona.news_app.model;

/**
 * Created by leona on 6/28/2017.
 */

public class NewsItem {
    public NewsItem() {
    }




    //info on json parsing
    //url:
    //urlToImage:
    //publishedAt:
    //author:
    //title:
    //description:
    //source??
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String author;
    public String title;
    public String description;
    public String source;

  //oarg construct??
    public NewsItem(String url, String urlToImage, String publishedAt, String author, String title, String description) {
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.author = author;
        this.title = title;
        this.description = description;

    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
