// NewsItem.java nâng cấp đầy đủ theo Post.java
package com.example.newsapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NewsItem {
    private String image;              // Đường dẫn ảnh (URL hoặc từ resource nội bộ)
    private String title;              // Tiêu đề
    private String content;            // Nội dung HTML
    private LocalDateTime createAt;    // Thời gian tạo bài viết
    private List<String> postCatalogues; // Danh sách chủ đề
    private int order;                 // Lượt xem hoặc thứ tự
    private String language;           // Ngôn ngữ bài viết

    private boolean isHeader = false;  // Đánh dấu là mục tiêu đề
    private int imageResId = 0;        // ID ảnh từ drawable nếu không dùng URL

    public NewsItem() {}

    // Constructor có đủ thông tin chi tiết
    public NewsItem(String image, String title, String content, LocalDateTime createAt,
                    List<String> postCatalogues, int order, String language) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.postCatalogues = postCatalogues;
        this.order = order;
        this.language = language;
        this.isHeader = false;
    }

    // Constructor dành cho header
    public NewsItem(String title) {
        this.title = title;
        this.isHeader = true;
    }

    // Các getter và setter
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setCreateAtFromString(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.createAt = LocalDateTime.parse(dateTimeString, formatter);
    }

    public String getFormattedCreateAt() {
        if (createAt == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return createAt.format(formatter);
    }

    public List<String> getPostCatalogues() {
        return postCatalogues;
    }

    public void setPostCatalogues(List<String> postCatalogues) {
        this.postCatalogues = postCatalogues;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
