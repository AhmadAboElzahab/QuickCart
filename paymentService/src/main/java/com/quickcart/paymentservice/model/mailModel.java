package com.quickcart.paymentservice.model;

public class mailModel {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    String email;

    public mailModel() {
    }

    Double amount;

    public mailModel(String email, Double amount) {
        this.email = email;
        this.amount = amount;
    }
}
