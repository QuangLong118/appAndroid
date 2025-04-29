package com.example.btl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private Context context;
    private List<Article> articleList;

    public ArticleAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.article_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.titleTextView.setText(article.getTitle());
        holder.descriptionTextView.setText(article.getTime());
        holder.timeTextView.setText(article.getTimeAgo());
        holder.imageView.setImageResource(article.getImageResource());

        // Set on click listener to open the article detail page
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ArticleDetailActivity.class);
            intent.putExtra("title", article.getTitle());
            intent.putExtra("time", article.getTime());
            intent.putExtra("timeAgo", article.getTimeAgo());
            intent.putExtra("imageResource", article.getImageResource());
            intent.putExtra("fullContent", article.getFullContent());
            // Truyền nội dung chi tiết bài báo
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        TextView timeTextView;
        ImageView imageView;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.article_title);
            descriptionTextView = itemView.findViewById(R.id.article_description);
            timeTextView = itemView.findViewById(R.id.article_time);
            imageView = itemView.findViewById(R.id.article_image);
        }
    }
}
