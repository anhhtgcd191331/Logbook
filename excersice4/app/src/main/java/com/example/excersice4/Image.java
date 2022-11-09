package com.example.excersice4;

public class Image {
    private int id;
    private String name;
    private String place;
    private byte[] image;

    public Image(int id, String name, String place, byte[] image) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
