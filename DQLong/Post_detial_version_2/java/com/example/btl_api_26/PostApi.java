package com.example.btl_api_26;

import retrofit2.Call;
import retrofit2.http.GET;


import java.util.List;

public interface PostApi {

    @GET("post/post/android") // Đảm bảo đường dẫn API đúng
    Call<List<Post>> getPosts(); // Trả về danh sách các đối tượng Post
}
