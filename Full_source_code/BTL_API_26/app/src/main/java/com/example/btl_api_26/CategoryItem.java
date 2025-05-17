package com.example.btl_api_26;


public class CategoryItem {
    private String name;
    private String imageUrl;

    public CategoryItem(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}