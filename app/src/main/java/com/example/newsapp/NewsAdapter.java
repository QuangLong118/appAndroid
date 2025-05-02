package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewsItem> newsList;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NEWS = 1;

    public NewsAdapter(List<NewsItem> newsList) {
        this.newsList = newsList;
    }

    @Override
    public int getItemViewType(int position) {
        return newsList.get(position).isHeader() ? TYPE_HEADER : TYPE_NEWS;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
            return new NewsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsItem newsItem = newsList.get(position);

        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).headerTitle.setText(newsItem.getTitle());
        } else if (holder instanceof NewsViewHolder) {
            NewsViewHolder newsHolder = (NewsViewHolder) holder;
            newsHolder.titleTextView.setText(newsItem.getTitle());
            newsHolder.sourceTextView.setText("Ngôn ngữ: " + newsItem.getLanguage());
            newsHolder.timeTextView.setText(newsItem.getFormattedCreateAt());

            // Hiển thị ảnh
            if (newsItem.getImageResId() != 0) {
                newsHolder.newsImageView.setImageResource(newsItem.getImageResId());
            } else if (newsItem.getImage() != null) {
                Glide.with(newsHolder.itemView.getContext())
                        .load(newsItem.getImage())
                        .fitCenter()
                        .into(newsHolder.newsImageView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImageView;
        TextView titleTextView, sourceTextView, timeTextView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.news_image);
            titleTextView = itemView.findViewById(R.id.news_title);
            sourceTextView = itemView.findViewById(R.id.news_source);
            timeTextView = itemView.findViewById(R.id.news_time);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitle;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTitle = itemView.findViewById(R.id.header_title);
        }
    }
}
