package com.example.bao;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_FEATURED = 1;

    private Context context;
    private List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_FEATURED) {
            // Layout cho bài báo tâm điểm
            View view = LayoutInflater.from(context).inflate(R.layout.item_post_featured, parent, false);
            return new FeaturedPostViewHolder(view);
        } else {
            // Layout cho bài báo bình thường
            View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
            return new PostViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = postList.get(position);
        if (holder instanceof PostViewHolder) {
            // Bài báo bình thường
            PostViewHolder postHolder = (PostViewHolder) holder;
            postHolder.textTitle.setText(post.getTitle());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                postHolder.textSourceTime.setText(post.getLanguage() + " • " + post.getFormattedCreateAt());
            }

            Glide.with(context)
                    .load(post.getImage())
                    .placeholder(R.drawable.ic_placeholder)
                    .into(postHolder.imageThumbnail);
        } else if (holder instanceof FeaturedPostViewHolder) {
            // Bài báo tâm điểm
            FeaturedPostViewHolder featuredHolder = (FeaturedPostViewHolder) holder;
            featuredHolder.textTitle.setText(post.getTitle());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                featuredHolder.textSourceTime.setText(post.getLanguage() + " • " + post.getFormattedCreateAt());
            }

            // Load 3 ảnh cho bài báo tâm điểm
            Glide.with(context)
                    .load(post.getImage())
                    .placeholder(R.drawable.ic_placeholder)
                    .into(featuredHolder.imageThumbnail1);
            Glide.with(context)
                    .load(post.getImage()) // Bạn có thể thay thế đây bằng các ảnh khác nếu cần
                    .placeholder(R.drawable.ic_placeholder)
                    .into(featuredHolder.imageThumbnail2);
            Glide.with(context)
                    .load(post.getImage()) // Cũng vậy
                    .placeholder(R.drawable.ic_placeholder)
                    .into(featuredHolder.imageThumbnail3);
        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public int getItemViewType(int position) {
        // Mỗi 3 bài báo sẽ có một bài báo tâm điểm
        return position % 3 == 0 ? VIEW_TYPE_FEATURED : VIEW_TYPE_NORMAL;
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

    public static class FeaturedPostViewHolder extends RecyclerView.ViewHolder {
        ImageView imageThumbnail1, imageThumbnail2, imageThumbnail3;
        TextView textTitle, textSourceTime;

        public FeaturedPostViewHolder(@NonNull View itemView) {
            super(itemView);
            imageThumbnail1 = itemView.findViewById(R.id.image_thumbnail_1);
            imageThumbnail2 = itemView.findViewById(R.id.image_thumbnail_2);
            imageThumbnail3 = itemView.findViewById(R.id.image_thumbnail_3);
            textTitle = itemView.findViewById(R.id.text_title);
            textSourceTime = itemView.findViewById(R.id.text_source_time);
        }
    }
}
