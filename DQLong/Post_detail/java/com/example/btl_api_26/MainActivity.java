package com.example.btl_api_26;


import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Post> postList = Arrays.asList(
                new Post("https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482770KCr/anh-mo-ta.png", "Bài viết 1", "<p>Nội dung 1</p> <img src = \"https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482770KCr/anh-mo-ta.png\" alt = \"Chém gió\"/>",
                        LocalDateTime.now(), Arrays.asList("an toàn", "giao thông"), 1, "vi"),
                new Post("https://www.ruaanhgiare.vn/wp-content/uploads/2023/06/anh-ngau.jpg", "Bài viết 2", "<p>Nội dung 2</p>",
                        LocalDateTime.now().minusDays(1), Arrays.asList("tin tức"), 2, "vi"),
        new Post("https://www.ruaanhgiare.vn/wp-content/uploads/2023/06/anh-ngau.jpg", "Bài viết 2", "<p>Nội dung 2</p>",
                LocalDateTime.now().minusDays(1), Arrays.asList("tin tức"), 2, "vi"),
        new Post("https://www.ruaanhgiare.vn/wp-content/uploads/2023/06/anh-ngau.jpg", "Bài viết 2", "<p>Nội dung 2</p>",
                LocalDateTime.now().minusDays(1), Arrays.asList("tin tức"), 2, "vi"),
        new Post("https://www.ruaanhgiare.vn/wp-content/uploads/2023/06/anh-ngau.jpg", "Bài viết 2", "<p>Nội dung 2</p>",
                LocalDateTime.now().minusDays(1), Arrays.asList("tin tức"), 2, "vi"),
        new Post("https://www.ruaanhgiare.vn/wp-content/uploads/2023/06/anh-ngau.jpg", "Bài viết 2", "<p>Nội dung 2</p>",
                LocalDateTime.now().minusDays(1), Arrays.asList("tin tức"), 2, "vi"),
        new Post("https://www.ruaanhgiare.vn/wp-content/uploads/2023/06/anh-ngau.jpg", "Bài viết 2", "<p>Nội dung 2</p>",
                LocalDateTime.now().minusDays(1), Arrays.asList("tin tức"), 2, "vi")
        );

        adapter = new PostAdapter(this, postList, post -> {
            Intent intent = new Intent(MainActivity.this, PostDetailActivity.class);
            intent.putExtra("title", post.getTitle());
            intent.putExtra("content", post.getContent());
            intent.putExtra("image", post.getImage());
            intent.putExtra("date", post.getFormattedCreateAt());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
        Log.d("DEBUG", "Bước 4: end");

    }
}

