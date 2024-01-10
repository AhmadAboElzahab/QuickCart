package com.quickcart.paymentservice.model;

public class paymentResponseModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSecurityCode() {
        return securityCode;
    }

    public paymentResponseModel(Long id, String email, Long securityCode) {
        this.id = id;
        this.email = email;
        this.securityCode = securityCode;
    }

    public void setSecurityCode(Long securityCode) {
        this.securityCode = securityCode;
    }

    private Long id;

    public paymentResponseModel() {
    }

    private String email;
    private Long securityCode;


}