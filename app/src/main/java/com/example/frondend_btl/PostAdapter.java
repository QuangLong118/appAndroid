package com.example.frondend_btl;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private final List<Post> postList;

    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView newsTitle, newsSource;

        public PostViewHolder(View view) {
            super(view);
            newsImage = view.findViewById(R.id.newsImage);
            newsTitle = view.findViewById(R.id.newsTitle);
            newsSource = view.findViewById(R.id.newsSource);
        }
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);

        holder.newsTitle.setText(post.getTitle());
        holder.newsSource.setText(post.getFormattedCreateAt());
        Picasso.get().load(post.getImage()).into(holder.newsImage);

        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, NewsDetailActivity.class);
            intent.putExtra("title", post.getTitle());
            intent.putExtra("source", post.getFormattedCreateAt());
            intent.putExtra("image", post.getImage());
            intent.putExtra("content", post.getContent());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
