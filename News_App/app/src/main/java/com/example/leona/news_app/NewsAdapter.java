package com.example.leona.news_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leona.news_app.model.NewsItem;

import java.util.ArrayList;

/**
 * Created by leona on 6/28/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>{

    private ArrayList<NewsItem> newsData;
    ItemClickListener listener;

    public NewsAdapter(ArrayList<NewsItem> newsData, ItemClickListener listener) {
        this.newsData = newsData;
        this.listener = listener;
    }

    public interface ItemClickListener {
        void onItemClick(int itemIndex);
    }

    @Override
    public NewsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recycleview, parent, false);

        NewsItemViewHolder holder = new NewsItemViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder (NewsItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (newsData == null) {
            return 0;
        }
        else {
            return newsData.size();
        }
    }

    class NewsItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        TextView description;
        TextView publishedAt;
      //  ImageView urlToImage;

        NewsItemViewHolder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.news_title);
            description = (TextView)view.findViewById(R.id.news_description);
            publishedAt = (TextView)view.findViewById(R.id.news_time);
           // urlToImage  = (ImageView)view.findViewById(R.id.news_image);
            view.setOnClickListener(this);
        }

        public void bind(int pos){
            NewsItem item = newsData.get(pos);
            title.setText(item.getTitle());
            description.setText(item.getDescription());
            publishedAt.setText(item.getPublishedAt());
          //  urlToImage.setImageURI(item.getUrlToImage());
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            listener.onItemClick(pos);
        }
    }
}
