package com.quickcart.paymentservice.model;

public class productModel {
    private int id;
    private String title;
    private double price;
    private String image;
    private int categoryId;
    private categoryModel category;


    public productModel() {
    }

    public productModel(int id, String title, double price, String image, int categoryId, categoryModel category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.image = image;
        this.categoryId = categoryId;
        this.category = category;
    }

    // Getters and setters for each field

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public categoryModel getCategory() {
        return category;
    }

    public void setCategory(categoryModel category) {
        this.category = category;
    }
}
