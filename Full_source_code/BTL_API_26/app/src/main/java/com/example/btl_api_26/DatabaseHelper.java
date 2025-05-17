package com.example.btl_api_26;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "app_settings.db";
    private static final int DATABASE_VERSION = 1;

    // Tên bảng và cột
    public static final String TABLE_LANGUAGE = "language";
    public static final String COLUMN_LANG = "current_lang";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng language với 1 bản ghi mặc định là 'vi'
        String createTable = "CREATE TABLE " + TABLE_LANGUAGE + " (" +
                COLUMN_LANG + " TEXT NOT NULL)";
        db.execSQL(createTable);

        // Thêm giá trị mặc định ban đầu là 'vi'
        String insertDefault = "INSERT INTO " + TABLE_LANGUAGE + " VALUES ('vi')";
        db.execSQL(insertDefault);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xoá bảng nếu cần cập nhật
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LANGUAGE);
        onCreate(db);
    }

    // Cập nhật ngôn ngữ
    public void updateLanguage(String newLang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LANG, newLang);
        db.update(TABLE_LANGUAGE, values, null, null);
        db.close();
    }

    // Lấy ngôn ngữ hiện tại
    public String getCurrentLanguage() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_LANG + " FROM " + TABLE_LANGUAGE + " LIMIT 1", null);
        String lang = "vi"; // mặc định
        if (cursor.moveToFirst()) {
            lang = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return lang;
    }
}
