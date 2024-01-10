package com.quickcart.paymentservice.model;

public class paymentRequestModel {


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Long securityCode) {
        this.securityCode = securityCode;
    }



    public paymentRequestModel() {
    }

    private String email;
    private Long securityCode;
    private Long amount;

    public paymentRequestModel(String email, Long securityCode, Long amount) {
        this.email = email;
        this.securityCode = securityCode;
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
