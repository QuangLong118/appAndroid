package com.example.bao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context context;
    private List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.textTitle.setText(post.getTitle());
        holder.textSourceTime.setText(post.getLanguage() + " • " + post.getFormattedCreateAt());

        // Load ảnh với Glide (nhớ thêm dependency Glide)
        Glide.with(context)
                .load(post.getImage())
                .placeholder(R.drawable.ic_placeholder)
                .into(holder.imageThumbnail);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView imageThumbnail;
        TextView textTitle, textSourceTime;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imageThumbnail = itemView.findViewById(R.id.image_thumbnail);
            textTitle = itemView.findViewById(R.id.text_title);
            textSourceTime = itemView.findViewById(R.id.text_source_time);
        }
    }
}
