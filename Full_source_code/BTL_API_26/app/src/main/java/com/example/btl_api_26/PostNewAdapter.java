package com.example.btl_api_26;

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

public class PostNewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_FEATURED = 1;

    private Context context;
    private List<Post> postList;
    private OnItemClickListener listener;

    // Interface xử lý sự kiện click
    public interface OnItemClickListener {
        void onItemClick(Post post);
    }

    // Hàm set listener từ ngoài vào
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PostNewAdapter(Context context, List<Post> postList,OnItemClickListener listener) {
        this.context = context;
        this.postList = postList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_FEATURED) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_post_featured, parent, false);
            return new FeaturedPostViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
            return new PostViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = postList.get(position);
        if (holder instanceof PostViewHolder) {
            PostViewHolder postHolder = (PostViewHolder) holder;
            postHolder.textTitle.setText(post.getTitle());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                postHolder.textSourceTime.setText(post.getLanguage() + " • " + post.getFormattedCreateAt());
            }
            Glide.with(context)
                    .load(post.getImage())
                    .placeholder(R.drawable.ic_placeholder)
                    .into(postHolder.imageThumbnail);

            postHolder.itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(post);
                }
            });

        } else if (holder instanceof FeaturedPostViewHolder) {
            FeaturedPostViewHolder featuredHolder = (FeaturedPostViewHolder) holder;
            featuredHolder.textTitle.setText(post.getTitle());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                featuredHolder.textSourceTime.setText(post.getLanguage() + " • " + post.getFormattedCreateAt());
            }

            Glide.with(context)
                    .load(post.getImage())
                    .placeholder(R.drawable.ic_placeholder)
                    .into(featuredHolder.imageThumbnail1);
//            Glide.with(context)
//                    .load(post.getImage())
//                    .placeholder(R.drawable.ic_placeholder)
//                    .into(featuredHolder.imageThumbnail2);
//            Glide.with(context)
//                    .load(post.getImage())
//                    .placeholder(R.drawable.ic_placeholder)
//                    .into(featuredHolder.imageThumbnail3);

            featuredHolder.itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(post);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public int getItemViewType(int position) {
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
//            imageThumbnail2 = itemView.findViewById(R.id.image_thumbnail_2);
//            imageThumbnail3 = itemView.findViewById(R.id.image_thumbnail_3);
            textTitle = itemView.findViewById(R.id.text_title);
            textSourceTime = itemView.findViewById(R.id.text_source_time);
        }
    }
}
