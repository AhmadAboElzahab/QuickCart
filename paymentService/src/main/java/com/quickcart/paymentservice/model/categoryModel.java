package com.quickcart.paymentservice.model;

public class categoryModel {
    private String title;
    private int id;

    // Constructors, getters, and setters

    public categoryModel() {
    }

    public categoryModel(String title, int id) {
        this.title = title;
        this.id = id;
    }

    // Getters and setters for each field

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}