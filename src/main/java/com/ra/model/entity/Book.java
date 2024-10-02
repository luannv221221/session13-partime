package com.ra.model.entity;

public class Book {
    private int id;
    private String title;
    private String description;
    private double price;
    private String author;

    public Book() {
    }

    public Book(int id, String title, String description, double price, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.author = author;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
