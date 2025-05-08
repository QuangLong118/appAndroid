package com.example.btl_api_26;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public String getFormattedCreateAt() {
        if (createAt == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return createAt.format(formatter);
    }

    // Parse chuỗi vào createAt
    public void setCreateAtFromString(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.createAt = LocalDateTime.parse(dateTimeString, formatter);
    }


}

