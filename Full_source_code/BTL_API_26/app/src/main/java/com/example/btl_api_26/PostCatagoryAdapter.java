package com.example.btl_api_26;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
//
import java.util.List;

public class PostCatagoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_REGULAR = 0;
    private static final int VIEW_TYPE_FEATURED = 1;

    private List<Post> postList;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Post post);
    }

    public PostCatagoryAdapter(Context context, List<Post> postList, OnItemClickListener listener) {
        this.context = context;
        this.postList = postList;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position > 0 && position % 4 == 3) {
            return VIEW_TYPE_FEATURED;
        }
        return VIEW_TYPE_REGULAR;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_FEATURED) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_featured_post, parent, false);
            return new FeaturedViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
            return new RegularViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = postList.get(position);

        if (holder instanceof RegularViewHolder) {
            RegularViewHolder regularHolder = (RegularViewHolder) holder;
            regularHolder.titlePost.setText(post.getTitle());
            regularHolder.postTime.setText(getTimeDifference(post.getCreateAt()));

            // Load image using Picasso library
            if (post.getImage() != null && !post.getImage().isEmpty()) {
                Picasso.get().load(post.getImage()).into(regularHolder.imagePost);
            }


            // Set source icon based on postCatalogues
            setSourceIcon(regularHolder.sourceIcon, post.getPostCatalogues());

        } else if (holder instanceof FeaturedViewHolder) {
            FeaturedViewHolder featuredHolder = (FeaturedViewHolder) holder;
            featuredHolder.titleFeaturedPost.setText(post.getTitle());
            featuredHolder.postFeaturedTime.setText(getTimeDifference(post.getCreateAt()));

            // Load image using Picasso library
            if (post.getImage() != null && !post.getImage().isEmpty()) {
                Picasso.get().load(post.getImage()).into(featuredHolder.imageFeaturedPost);
            }

            // Set source icon based on postCatalogues
            setSourceIcon(featuredHolder.sourceFeaturedIcon, post.getPostCatalogues());
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(post);
            }
        });
    }

    private void setSourceIcon(ImageView imageView, String source) {
        // Implementation to load appropriate source icon
        // For now, just use a placeholder
        imageView.setImageResource(android.R.drawable.ic_menu_recent_history);
    }

    private String getTimeDifference(String createAt) {
        // A simple placeholder implementation
        // You should implement proper time difference calculation
        return "3 giờ";
    }

    @Override
    public int getItemCount() {
        return postList != null ? postList.size() : 0;
    }

    public static class RegularViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePost;
        TextView titlePost;
        ImageView sourceIcon;
        TextView postTime;

        public RegularViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePost = itemView.findViewById(R.id.imagePost);
            titlePost = itemView.findViewById(R.id.titlePost);
            sourceIcon = itemView.findViewById(R.id.sourceIcon);
            postTime = itemView.findViewById(R.id.postTime);
        }
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {
        ImageView imageFeaturedPost;
        TextView titleFeaturedPost;
        ImageView sourceFeaturedIcon;
        TextView postFeaturedTime;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFeaturedPost = itemView.findViewById(R.id.imageFeaturedPost);
            titleFeaturedPost = itemView.findViewById(R.id.titleFeaturedPost);
            sourceFeaturedIcon = itemView.findViewById(R.id.sourceFeaturedIcon);
            postFeaturedTime = itemView.findViewById(R.id.postFeaturedTime);
        }
    }
}