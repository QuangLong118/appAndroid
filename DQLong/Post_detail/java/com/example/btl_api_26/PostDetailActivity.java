package com.example.btl_api_26;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PostDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txtTitle, txtDate;
    WebView webView;
    private RecyclerView recyclerView;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        // Khởi tạo các thành phần giao diện
        recyclerView = findViewById(R.id.recyclerView);
        imageView = findViewById(R.id.imageView);
        txtTitle = findViewById(R.id.txtTitle);
        txtDate = findViewById(R.id.txtDate);
        webView = findViewById(R.id.webView);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String date = intent.getStringExtra("date");
        String content = intent.getStringExtra("content");
        String imageUrl = intent.getStringExtra("image");

        // Hiển thị dữ liệu lên giao diện
        txtTitle.setText(title);
        txtDate.setText(date);
        webView.loadData(content, "text/html", "UTF-8");

        Glide.with(this).load(imageUrl).into(imageView);

        // Tạo danh sách bài đăng cho RecyclerView
        List<Post> postList = Arrays.asList(
                new Post("https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482770KCr/anh-mo-ta.png", "Bài viết 1", "<p>Nội dung 1</p> <img src = \"https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482770KCr/anh-mo-ta.png\" alt = \"Chém gió\"/>",
                        LocalDateTime.now(), Arrays.asList("an toàn", "giao thông"), 1, "vi"),

                new Post("https://www.ruaanhgiare.vn/wp-content/uploads/2023/06/anh-ngau.jpg", "Bài viết 2", "<p>Nội dung 2</p>",
                        LocalDateTime.now().minusDays(1), Arrays.asList("tin tức"), 2, "vi")
        );

        // Cấu hình RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(this, postList, post -> {
            // Khi click vào bài viết trong RecyclerView, mở chi tiết bài viết
            Intent intent2 = new Intent(PostDetailActivity.this, PostDetailActivity.class);
            intent2.putExtra("title", post.getTitle());
            intent2.putExtra("content", post.getContent());
            intent2.putExtra("image", post.getImage());
            intent2.putExtra("date", post.getFormattedCreateAt());
            startActivity(intent2);
        });

        // Gán Adapter cho RecyclerView
        recyclerView.setAdapter(adapter);

        ImageButton btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(v -> {
            Intent intent2 = new Intent(PostDetailActivity.this, MainActivity.class);
            intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent2);
            finish(); // Đóng activity hiện tại
        });

    }
}
