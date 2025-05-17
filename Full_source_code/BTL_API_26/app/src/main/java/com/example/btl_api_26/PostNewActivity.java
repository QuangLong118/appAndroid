package com.example.btl_api_26;

import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostNewActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPosts;
    private PostNewAdapter postNewApdater;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_posts);

        recyclerViewPosts = findViewById(R.id.recyclerViewPosts);
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));

        // Dữ liệu mẫu
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                "11/08/2003 11:05:05",
                125,
                "vi",
                "sức khỏe"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                "11/08/2003 11:05:05",
                125,
                "vi",
                "sức khỏe"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                "11/08/2003 11:05:05",
                125,
                "vi",
                "sức khỏe"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                "11/08/2003 11:05:05",
                125,
                "vi",
                "sức khỏe"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                "11/08/2003 11:05:05",
                125,
                "vi",
                "sức khỏe"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                "11/08/2003 11:05:05",
                125,
                "vi",
                "sức khỏe"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                "11/08/2003 11:05:05",
                125,
                "vi",
                "sức khỏe"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                "11/08/2003 11:05:05",
                125,
                "vi",
                "sức khỏe"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                "11/08/2003 11:05:05",
                125,
                "vi",
                "sức khỏe"
        ));
        postNewApdater = new PostNewAdapter(this, posts);
        recyclerViewPosts.setAdapter(postNewApdater);
    }
}
