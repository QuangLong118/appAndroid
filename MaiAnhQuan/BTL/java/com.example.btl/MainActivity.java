package com.example.btl;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;
    private List<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.articlesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data with links
        articleList = new ArrayList<>();
        articleList.add(new Article("Lỗi xương ống tai khiến người phụ nữ suy giảm thính lực",
                "", "",
                R.drawable.img_1, "Lỗi xương ống tai khiến một phụ nử 37 tuổi ở Đồng Nai bị suy giảm thính lực, lắng nghe mọi thứ bị khó"));
        articleList.add(new Article("Tìm thấy bức tranh cổ, mô tả chi tiết là 1.500 năm trước",
                "", "",
                R.drawable.img_2,"5 nhà khảo cổ học người Mỹ đã tìm thấy một bức tranh cổ tại Massachusetts, Mỹ"));
        articleList.add(new Article("Người dân đổ dồn về trung tâm TPHCM trước chính lễ 30/4",
                "", "",
                R.drawable.img_3,"Người dân đổ dồn về trung tâm TPHCM trước chính lễ 30/4"));
        articleList.add(new Article("Giá vàng miếng lại vượt 121 triệu đồng/lượng",
                "", "",
                R.drawable.img_4,"Giá vàng miếng lại vượt 121 triệu đồng/lượng"));
        articleList.add(new Article("Những chính sách mới nổi bật có hiệu lực trong tháng 5/2025",
                "", "",
                R.drawable.img_5,"Những chính sách mới nổi bật có hiệu lực trong tháng 5/2025"));
        articleList.add(new Article("Supachok bị CLB Nhật Bản gạch tên",
                "", "",
                R.drawable.img_6,"Supachok bị CLB Nhật Bản gạch tên"));
        articleList.add(new Article("Bẻ lái gấp tránh hỏa lực Houthi, tàu sân bay Mỹ \"đánh rơi\" tiêm kích 60 triệu USD",
                "", "",
                R.drawable.img_7,"Bẻ lái gấp tránh hỏa lực Houthi, tàu sân bay Mỹ \"đánh rơi\" tiêm kích 60 triệu USD"));
        articleList.add(new Article("Tin vui từ 1/7/2025: Người tham gia BHYT đủ 5 năm liên tục có thể được thanh toán 100% chi phí khám chữa bệnh",
                "", "",
                R.drawable.img_8,"Tin vui từ 1/7/2025: Người tham gia BHYT đủ 5 năm liên tục có thể được thanh toán 100% chi phí khám chữa bệnh"));
        // Set the adapter
        articleAdapter = new ArticleAdapter(this, articleList);
        recyclerView.setAdapter(articleAdapter);
    }
}

