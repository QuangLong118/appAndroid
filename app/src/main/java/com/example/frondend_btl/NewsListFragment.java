package com.example.frondend_btl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class NewsListFragment extends Fragment {

    private static final String ARG_TYPE = "type";

    public static NewsListFragment newInstance(String type) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.newsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // ✅ Tạo danh sách Post thay vì NewsItem
        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("Tổng Bí thư: Việt Nam coi Hoa Kỳ là đối tác...");
        post1.setImage("https://picsum.photos/500/300");
        post1.setContent("<p>Đây là nội dung bài báo 1</p>");
        post1.setCreateAtFromString("2025/05/08 08:00:00");
        postList.add(post1);

        Post post2 = new Post();
        post2.setTitle("Sau điện đàm với Trump, Putin lập tức ra lệnh...");
        post2.setImage("https://picsum.photos/500/301");
        post2.setContent("<p>Đây là nội dung bài báo 2</p>");
        post2.setCreateAtFromString("2025/05/08 09:00:00");
        postList.add(post2);

        Post post3 = new Post();
        post3.setTitle("Chính thức từ 1/7...");
        post3.setImage("https://picsum.photos/500/302");
        post3.setContent("<p>Đây là nội dung bài báo 3</p>");
        post3.setCreateAtFromString("2025/05/08 10:00:00");
        postList.add(post3);

        recyclerView.setAdapter(new PostAdapter(postList));

        return view;
    }
}
