

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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
        setClickTopNav();
        loadPostsFromApi();
    }

    private void setClickTopNav(){
        TextView newTag = findViewById(R.id.tab_moi);
        newTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostNewActivity.class);
                startActivity(intent);
            }
        });
        TextView newHot = findViewById(R.id.tab_nong);
        newHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ImageView catagoryBtn = findViewById(R.id.catagory);
        catagoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CatagoryActivity.class);
                startActivity(intent);
            }
        });
        ImageView toolBtn = findViewById(R.id.tools);
        toolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
    private void loadPostsFromApi() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
//        dbHelper.updateLanguage("vi");
        String lang = dbHelper.getCurrentLanguage();
        PostApi api = RetrofitClient.getRetrofitInstance().create(PostApi.class);
        Call<List<Post>> call = api.getPosts();
        Log.d("DEBUG","4");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Post> post_APIs = response.body();
                    List<Post> posts = new ArrayList<>();
                    for (Post post : post_APIs){
                        if(post.getLanguage().equals(lang)){
                            post.update();
                            posts.add(post);
                        }

                        Log.d("ceck222",post.getContent());
                    }

    
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

