package com.example.btl_api_26;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


import retrofit2.Response;



public class PostNewActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPosts;
    private PostNewAdapter postNewApdater;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_new);

        recyclerViewPosts = findViewById(R.id.recyclerViewPosts);
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));

        TextView newHot = findViewById(R.id.tab_nong);
        newHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostNewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        loadPostsFromApi();
    }
    private void loadPostsFromApi() {
        PostApi api = RetrofitClient.getRetrofitInstance().create(PostApi.class);
        Call<List<Post>> call = api.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Post> posts = response.body();
                    for (Post post : posts){

                        post.update();
                        Log.d("duonglong",post.getContent());
                    }


                    postNewApdater = new PostNewAdapter(PostNewActivity.this, posts, post -> {
                        Intent intent = new Intent(PostNewActivity.this, PostDetailActivity.class);
                        intent.putExtra("title", post.getTitle());
                        intent.putExtra("content", post.getContent());
                        intent.putExtra("image", post.getImage());
                        intent.putExtra("date", post.getFormattedCreateAt());
                        startActivity(intent);
                    });
                    recyclerViewPosts.setAdapter(postNewApdater);

                    Toast.makeText(PostNewActivity.this, "Láy dữ liệu thành công!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PostNewActivity.this, "Lỗi khi lấy dữ liệu!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("API_ERROR", "Lỗi kết nối: " + t.getMessage(), t);
                Toast.makeText(PostNewActivity.this, "Không thể kết nối API!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
