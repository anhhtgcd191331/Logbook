package com.example.temple_demo_assi;

public class Cloud {
    String names;
    String uploadResponseCode;
    String message;
    int number;
    String userId;

    public Cloud(String names, String uploadResponseCode, String message, int number, String userId) {
        this.names = names;
        this.uploadResponseCode = uploadResponseCode;
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

    public String getUploadResponseCode() {
        return uploadResponseCode;
    }

    public void setUploadResponseCode(String uploadResponseCode) {
        this.uploadResponseCode = uploadResponseCode;
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
