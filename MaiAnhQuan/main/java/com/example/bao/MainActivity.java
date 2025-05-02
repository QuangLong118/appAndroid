package com.example.bao;

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

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPosts;
    private PostAdapter postAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPosts = findViewById(R.id.recyclerViewPosts);
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));

        // Dữ liệu mẫu
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                LocalDateTime.now(),
                Arrays.asList("sức khỏe", "y tế"),
                123,
                "vi"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                LocalDateTime.now(),
                Arrays.asList("sức khỏe", "y tế"),
                124,
                "vi"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                LocalDateTime.now(),
                Arrays.asList("sức khỏe", "y tế"),
                125,
                "vi"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                LocalDateTime.now(),
                Arrays.asList("sức khỏe", "y tế"),
                126,
                "vi"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                LocalDateTime.now(),
                Arrays.asList("sức khỏe", "y tế"),
                127,
                "vi"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                LocalDateTime.now(),
                Arrays.asList("sức khỏe", "y tế"),
                128,
                "vi"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                LocalDateTime.now(),
                Arrays.asList("sức khỏe", "y tế"),
                129,
                "vi"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                LocalDateTime.now(),
                Arrays.asList("sức khỏe", "y tế"),
                130,
                "vi"
        ));
        posts.add(new Post(
                "https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg",
                "Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "<p>Nội dung</p>",
                LocalDateTime.now(),
                Arrays.asList("sức khỏe", "y tế"),
                131,
                "vi"
        ));
        postAdapter = new PostAdapter(this, posts);
        recyclerViewPosts.setAdapter(postAdapter);
    }
}
