package com.example.btl;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Article {
    private String title; // Tiêu đề bài báo
    private String time; // Mô tả ngắn của bài báo
    private String timeAgo; // Thời gian bài báo được đăng (Ví dụ: "1 phút trước")
    private int imageResource; // Hình ảnh của bài báo (ID tài nguyên hình ảnh)
    private String fullContent; // Nội dung chi tiết của bài báo

    private long timestamp;
    // Constructor
    public Article(String title, String time, String timeAgo, int imageResource, String fullContent) {
        this.title = title;
        this.time = getCurrentTime();
        this.timestamp = System.currentTimeMillis();
        this.imageResource = imageResource;
        this.fullContent = fullContent;
        this.timeAgo = getTimeAgo();

    }
    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date); // Trả về thời gian hiện tại theo định dạng "HH:mm:ss dd/MM/yyyy"
    }
    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    // Tính toán thời gian đã trôi qua từ khi bài báo được đăng
    public String getTimeAgo() {
        long currentTime = System.currentTimeMillis();
        long diff = currentTime - timestamp; // Tính chênh lệch giữa thời gian hiện tại và thời gian bài báo được đăng
        long minutes = diff / (1000 * 60); // Chuyển đổi chênh lệch từ mili giây sang phút
        return minutes + " phút trước"; // Trả về số phút đã trôi qua
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getFullContent() {
        return fullContent;  // Trả về nội dung chi tiết bài báo
    }


}

