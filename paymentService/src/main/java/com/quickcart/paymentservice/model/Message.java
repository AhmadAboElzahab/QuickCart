package com.quickcart.paymentservice.model;

public class Message
{
    private String message;

    public String getMsg() {
        return message;
    }

    public Message(String msg) {
        this.message = msg;
    }

    public Message() {
    }

    public void setMsg(String msg) {
        this.message = msg;
    }
}
