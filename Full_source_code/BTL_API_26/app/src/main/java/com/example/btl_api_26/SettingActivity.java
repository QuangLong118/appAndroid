package com.example.btl_api_26;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
    CheckBox checkVi, checkEn, checkCn;
    Button btnSave;
    ImageView btnNews;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        checkVi = findViewById(R.id.checkVi);
        checkEn = findViewById(R.id.checkEn);
        checkCn = findViewById(R.id.checkCn);
        btnSave = findViewById(R.id.btnSave);
        dbHelper = new DatabaseHelper(this);
        btnNews = findViewById(R.id.btnNews);

        // 🔹 Đọc từ DB
        String currentLang = dbHelper.getCurrentLanguage();
        switch (currentLang) {
            case "vi": checkVi.setChecked(true); break;
            case "en": checkEn.setChecked(true); break;
            case "cn": checkCn.setChecked(true); break;
        }

        checkVi.setOnClickListener(v -> {
            checkVi.setChecked(true);
            checkEn.setChecked(false);
            checkCn.setChecked(false);
        });

        checkEn.setOnClickListener(v -> {
            checkVi.setChecked(false);
            checkEn.setChecked(true);
            checkCn.setChecked(false);
        });

        checkCn.setOnClickListener(v -> {
            checkVi.setChecked(false);
            checkEn.setChecked(false);
            checkCn.setChecked(true);
        });

        btnSave.setOnClickListener(v -> {
            String lang = checkVi.isChecked() ? "vi" :
                    checkEn.isChecked() ? "en" :
                            checkCn.isChecked() ? "cn" : "vi";

            dbHelper.updateLanguage(lang);
            Toast.makeText(this, "Cập nhật ngôn ngữ thành công: " + lang, Toast.LENGTH_SHORT).show();
        });


        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
