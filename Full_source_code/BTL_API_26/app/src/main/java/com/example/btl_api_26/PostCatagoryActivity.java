package com.example.btl_api_26;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostCatagoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostCatagoryAdapter adapter;
    private List<Post> postList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post_catagory);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up back button click listener
        findViewById(R.id.btnBack).setOnClickListener(v -> onBackPressed());

        loadPostsFromApi();

        recyclerView.setAdapter(adapter);
    }

    private void loadPostsFromApi() {
        PostApi api = RetrofitClient.getRetrofitInstance().create(PostApi.class);
        Call<List<Post>> call = api.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Intent intent1 = getIntent();
                    String receivedCategory = intent1.getStringExtra("selected_category");
                    if(receivedCategory.equals("Nóng")){
                        Intent intentNew = new Intent(PostCatagoryActivity.this, MainActivity.class);
                        startActivity(intentNew);
                    }
                    if(receivedCategory.equals("Mới")){
                        Intent intentHot = new Intent(PostCatagoryActivity.this, PostNewActivity.class);
                        startActivity(intentHot);
                    }

                    TextView headerTitle = findViewById(R.id.headerTitle);
                    headerTitle.setText(receivedCategory);
                    List<Post> post_API = response.body();
                    List<Post> posts = new ArrayList<>();
                    for (Post post : post_API){
                        post.update();
                        if (post.getPostCatalogues().equals(receivedCategory)){
                            posts.add(post);
                        }
                    }
                    adapter = new PostCatagoryAdapter(PostCatagoryActivity.this, posts, post -> {
                    Intent intent = new Intent(PostCatagoryActivity.this, PostDetailActivity.class);
                    intent.putExtra("title", post.getTitle());
                    intent.putExtra("content", post.getContent());
                    intent.putExtra("image", post.getImage());
                    intent.putExtra("date", post.getFormattedCreateAt());
                    startActivity(intent);
                });

                recyclerView.setAdapter(adapter);
                // Toast.makeText(PostCatagoryActivity.this, "Láy dữ liệu thành công!",Toast.LENGTH_SHORT).show();
                } else {
                //     Toast.makeText(PostCatagoryActivity.this, "Lỗi khi lấy dữ liệu!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("API_ERROR", "Lỗi kết nối: " + t.getMessage(), t);
                Toast.makeText(PostCatagoryActivity.this, "Không thể kết nối API!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}