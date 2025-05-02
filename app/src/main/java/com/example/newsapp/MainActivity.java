// Cập nhật MainActivity.java để tạo NewsItem theo cấu trúc mới
package com.example.newsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private List<NewsItem> newsList;
    private ProgressBar progressBar;
    private ImageView logo;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        searchView = findViewById(R.id.search_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Glide.with(this).load(R.drawable.logo).into(logo);

        newsList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsAdapter);

        loadNews();
    }

    private void loadNews() {
        progressBar.setVisibility(View.VISIBLE);

        NewsItem header = new NewsItem("Tin thể thao");
        newsList.add(header);

        for (int i = 0; i < 10; i++) {
            NewsItem item = new NewsItem();
            item.setTitle("Messi trở lại");
            item.setContent("<p>Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC</p>");
            item.setImage("https://example.com/image_messi.jpg");
            item.setCreateAtFromString("2025/05/02 14:30:00");
            item.setPostCatalogues(Arrays.asList("bóng đá", "MLS", "Argentina"));
            item.setOrder(i + 1);
            item.setLanguage("vi");
            item.setImageResId(R.drawable.messi);
            newsList.add(item);
        }

        newsAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
} 
