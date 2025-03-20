package com.example.newsapp;

public class NewsItem {
    private String title;
    private String description;
    private int imageResId = 0;
    private String imageUrl = null;
    private boolean isHeader; // Đánh dấu item này là "tiêu đề"

    // Constructor cho tin tức (có ảnh)
    public NewsItem(String title, String description, int imageResId) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.imageUrl = null;
        this.isHeader = false;
    }

    // Constructor cho tin tức (ảnh từ URL)
    public NewsItem(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.imageResId = 0;
        this.isHeader = false;
    }

    // Constructor cho tiêu đề (chủ đề)
    public NewsItem(String title) {
        this.title = title;
        this.isHeader = true;
    }

    // Getter
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getImageResId() { return imageResId; }
    public String getImageUrl() { return imageUrl; }
    public boolean isHeader() { return isHeader; }
}
