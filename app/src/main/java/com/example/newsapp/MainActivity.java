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
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private List<NewsItem> newsList;
    private ProgressBar progressBar;
    private ImageView logo;
    private SearchView searchView;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment selectedFragment = null;
//
//                switch (item.getItemId()) {
//                    case R.id.nav_news:
//                        selectedFragment = new ProfileFragment();
//                        break;
//                    case R.id.nav_video:
//                        selectedFragment = new VideoFragment();
//                        break;
//                    case R.id.nav_trend:
//                        selectedFragment = new TrendFragment();
//                        break;
//                    case R.id.nav_profile:
//                        selectedFragment = new ProfileFragment();
//                        break;
//                }
//
//                if (selectedFragment != null) {
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.frame_layout, selectedFragment)
//                            .commit();
//                }
//
//                return true;
//            }
//        });
//
//        // Mặc định chọn tab "Tin tức"
//        if (savedInstanceState == null) {
//            bottomNavigationView.setSelectedItemId(R.id.nav_news);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        searchView = findViewById(R.id.search_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load logo
        Glide.with(this).load(R.drawable.logo).into(logo);

        newsList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsAdapter);

        loadNews();
    }

    private void loadNews() {
        progressBar.setVisibility(View.VISIBLE);
        // Giả lập dữ liệu tin tức
        newsList.add(new NewsItem("Tin thể thao"));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsList.add(new NewsItem("Messi trở lại", "Messi trở lại và ghi bàn giúp Inter Miami vào tứ kết CCC",R.drawable.messi));
        newsAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
}