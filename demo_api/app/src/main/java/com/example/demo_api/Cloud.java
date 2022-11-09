package com.example.demo_api;

public class Cloud {
    String names;
    String uploadResponseCon;
    String message;
    int number;
    String userId;

    public Cloud(String names, String uploadResponseCon, String message, int number, String userId) {
        this.names = names;
        this.uploadResponseCon = uploadResponseCon;
        this.message = message;
        this.number = number;
        this.userId = userId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getUploadResponseCon() {
        return uploadResponseCon;
    }

    public void setUploadResponseCon(String uploadResponseCon) {
        this.uploadResponseCon = uploadResponseCon;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
