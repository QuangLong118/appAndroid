package com.example.btl_api_26;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Post {
    private String image; // Ảnh đại diện
    private String title; // Tiêu đề
    private String content; // Nội dung
    private String createAt; // Thời gian tạo (đổi từ LocalDateTime sang String)
    private String postCatalogues; // Danh sách chủ đề
    private int order; // Lượt xem
    private String language; // Ngôn ngữ

    public Post() {
    }

    public Post(String image, String title, String content, String createAt, int order, String language,String postCatalogues) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.postCatalogues = postCatalogues;
        this.order = order;
        this.language = language;
    }

    public void update(){
        String imageUpdate = "http:/10.0.2.2:8000"+image;
        this.image = imageUpdate;
        this.content = replaceImgSrc(this.content);

    }

    public static String replaceImgSrc(String input) {
        if (input == null) return null;
        String inputUpdate=input.replace("img alt=\"\" src=\"", "img alt=\"\" style=\"max-width:100%; height:auto;\" src=\"http://10.0.2.2:8000");
        String htmlWrapper = "<html><head><style>" +
                "img { max-width: 100%; height: auto; display: block; margin: 0 auto; }" +
                "body { margin: 0; padding: 0; }" +
                "</style></head><body>" + inputUpdate + "</body></html>";
        return  htmlWrapper;
    }

    // Getter và Setter
    public String getImage() {
        return this.image;
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

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getPostCatalogues() {
        return postCatalogues;
    }

    public void setPostCatalogues(String postCatalogues) {
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

    // Format createAt từ định dạng gốc sang dạng đẹp (yyyy/MM/dd HH:mm:ss)
    public String getFormattedCreateAt() {
        if (createAt == null || createAt.isEmpty()) return "";
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()); // Ví dụ định dạng từ API
            Date date = inputFormat.parse(createAt);
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return createAt; // Trả nguyên chuỗi nếu lỗi
        }
    }
}
