package com.example.btl;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        // Khởi tạo Toolbar và Back button
        ImageView backButton = findViewById(R.id.back_button);

        // Thiết lập sự kiện khi người dùng nhấn nút back
        backButton.setOnClickListener(v -> {
            // Quay lại MainActivity
            finish(); // Kết thúc Activity hiện tại và quay lại Activity trước đó
        });

        // Các phần còn lại trong ArticleDetailActivity
        String title = getIntent().getStringExtra("title");
        String time = getIntent().getStringExtra("time");
        String timeAgo = getIntent().getStringExtra("timeAgo");
        int imageResource = getIntent().getIntExtra("imageResource", 0);
        String fullContent = getIntent().getStringExtra("fullContent");

        TextView titleTextView = findViewById(R.id.article_detail_title);
        TextView timetext = findViewById(R.id.article_time);
        TextView timeAgoTextView = findViewById(R.id.article_detail_time);
        TextView fullContentTextView = findViewById(R.id.article_detail_content);
        ImageView articleImageView = findViewById(R.id.article_detail_image);

        titleTextView.setText(title);
        timetext.setText(time);
        timeAgoTextView.setText(timeAgo);
        fullContentTextView.setText(fullContent);
        articleImageView.setImageResource(imageResource);
    }
}
