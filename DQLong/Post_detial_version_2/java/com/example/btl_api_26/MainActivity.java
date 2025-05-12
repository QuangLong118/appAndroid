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
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.btl_api_26.PostApi;
import com.example.btl_api_26.RetrofitClient;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadPostsFromApi();


        
    }
    private void loadPostsFromApi() {
        PostApi api = RetrofitClient.getRetrofitInstance().create(PostApi.class);
        Call<List<Post>> call = api.getPosts();
        Log.d("DEBUG","4");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Post> posts = response.body();
                    for (Post post : posts){

                        post.update();
                        Log.d("test_content",post.getContent());
                    }

                    Log.d("DEBUG","4");
                    adapter = new PostAdapter(MainActivity.this, posts, post -> {
                    Intent intent = new Intent(MainActivity.this, PostDetailActivity.class);
                    intent.putExtra("title", post.getTitle());
                    intent.putExtra("content", post.getContent());
                    intent.putExtra("image", post.getImage());
                    intent.putExtra("date", post.getFormattedCreateAt());
                    startActivity(intent);
                });

                recyclerView.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "Láy dữ liệu thành công!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Lỗi khi lấy dữ liệu!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("API_ERROR", "Lỗi kết nối: " + t.getMessage(), t);
                Toast.makeText(MainActivity.this, "Không thể kết nối API!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

