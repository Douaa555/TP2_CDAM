package com.example.tp2;

public class Item {
    private int image;
    private String name;
    private String category;
    private double price;
    public Item(int image, String name, String category, double price) {
        this.image = image;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

