package com.example.btl_api_26;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CatagoryActivity extends AppCompatActivity implements CategoryAdapter.OnCategoryClickListener {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private Button btnExit;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

        recyclerView = findViewById(R.id.category_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<CategoryItem> categories = createCategoryList();
        adapter = new CategoryAdapter(this, categories, this);
        recyclerView.setAdapter(adapter);

        btnExit = findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private List<CategoryItem> createCategoryList() {
        List<CategoryItem> categories = new ArrayList<>();
        categories.add(new CategoryItem("Nóng", "android.resource://" + getPackageName() + "/" + R.drawable.category_nong));
        categories.add(new CategoryItem("Mới", "android.resource://" + getPackageName() + "/" + R.drawable.category_moi));
        categories.add(new CategoryItem("THời sự", "android.resource://" + getPackageName() + "/" + R.drawable.category_bongda_vn));
        categories.add(new CategoryItem("Bóng đá", "android.resource://" + getPackageName() + "/" + R.drawable.category_bongda_qt));
        categories.add(new CategoryItem("Độc & Lạ", "android.resource://" + getPackageName() + "/" + R.drawable.category_doc_la));
        categories.add(new CategoryItem("Tình yêu", "android.resource://" + getPackageName() + "/" + R.drawable.category_tinh_yeu));
        categories.add(new CategoryItem("Giải trí", "android.resource://" + getPackageName() + "/" + R.drawable.category_giai_tri));
        categories.add(new CategoryItem("Thế giới", "android.resource://" + getPackageName() + "/" + R.drawable.category_the_gioi));
        categories.add(new CategoryItem("Pháp luật", "android.resource://" + getPackageName() + "/" + R.drawable.category_phap_luat));
        categories.add(new CategoryItem("Xe 360", "android.resource://" + getPackageName() + "/" + R.drawable.category_xe_360));
        categories.add(new CategoryItem("Công Nghệ", "android.resource://" + getPackageName() + "/" + R.drawable.category_cong_nghe));
        categories.add(new CategoryItem("Ẩm thực", "android.resource://" + getPackageName() + "/" + R.drawable.category_am_thuc));
        categories.add(new CategoryItem("Làm đẹp", "android.resource://" + getPackageName() + "/" + R.drawable.category_lam_dep));
        categories.add(new CategoryItem("Sức khỏe", "android.resource://" + getPackageName() + "/" + R.drawable.category_suc_khoe));
        return categories;
    }

    @Override
    public void onCategoryClick(int position) {
        // Handle category selection
        String selectedCategory = createCategoryList().get(position).getName();
        // Here you can use the Post class to filter by category
        Toast.makeText(this, "Selected category: " + selectedCategory, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CatagoryActivity.this, PostCatagoryActivity.class);
        intent.putExtra("selected_category", selectedCategory);
        startActivity(intent);
        // TODO: Implement post filtering by category using the Post class
        // Intent intent = new Intent(this, PostListActivity.class);
        // intent.putExtra("CATEGORY", selectedCategory);
        // startActivity(intent);
    }
}