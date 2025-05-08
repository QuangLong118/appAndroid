package com.example.frondend_btl;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {

    ImageView detailImage;
    TextView detailTitle, detailSource, detailContent;
    ImageView backButton; // 👈 thêm biến nút back

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        // Ánh xạ view
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);
        detailSource = findViewById(R.id.detailSource);
        detailContent = findViewById(R.id.detailContent);
        backButton = findViewById(R.id.backButton); // 👈 ánh xạ nút back từ XML

        // Gán dữ liệu từ Intent
        String title = getIntent().getStringExtra("title");
        String source = getIntent().getStringExtra("source");
        String image = getIntent().getStringExtra("image");

        detailTitle.setText(title);
        detailSource.setText(source);
        Picasso.get().load(image).into(detailImage);
        detailContent.setText("Đây là nội dung mô phỏng bài báo.");

        // 👈 Xử lý sự kiện nút back
        backButton.setOnClickListener(v -> finish());
    }
}
