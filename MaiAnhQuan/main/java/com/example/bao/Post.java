package com.example.bao;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
public class Post {

    private String image;// Ảnh đại diện
    private String title; //Tiêu đề
    private String content; //Nội dung
    private LocalDateTime createAt;// Thời gian tạo
    private List<String> postCatalogues; //Danh sách chủ để
    private int order; //Lượt xem
    private String language;// Ngôn ngữ

    public Post() {
    }

    public Post(String image, String title, String content, LocalDateTime createAt, List<String> postCatalogues, int order, String language) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.postCatalogues = postCatalogues;
        this.order = order;
        this.language = language;
    }

    // Getter và Setter
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

    // Format createAt thành yyyy/MM/dd HH:mm:ss
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getFormattedCreateAt() {
        if (createAt == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return createAt.format(formatter);
    }

    // Parse chuỗi vào createAt
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setCreateAtFromString(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.createAt = LocalDateTime.parse(dateTimeString, formatter);
    }

    // Hàm main để kiểm tra
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        Post post = new Post();
        post.setImage("https://photo-baomoi.bmcdn.me/w1000_r1/2025_04_23_114_52056754/bf82a5e7f7a91ef747b8.jpg");
        post.setTitle("Bài viết mẫu");
        post.setContent("<p>Đây là nội dung bài viết HTML.</p>");
        post.setCreateAtFromString("2025/05/02 14:30:00");
        post.setPostCatalogues(Arrays.asList("giao thông", "an toàn"));
        post.setOrder(1);
        post.setLanguage("vi");

        System.out.println("Tiêu đề: " + post.getTitle());
        System.out.println("Ngày tạo: " + post.getFormattedCreateAt());
        System.out.println("Danh mục: " + post.getPostCatalogues());
        System.out.println("Nội dung: " + post.getContent());
    }
}
