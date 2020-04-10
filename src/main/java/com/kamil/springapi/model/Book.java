package com.kamil.springapi.model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ISBN;
    private String title;
    private double price;
    private int category;
    private Date published_date;
    private int quantity;

    public Book() {

    }

    public Book(int ISBN, String title, double price, int category, Date published_date, int quantity) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.category = category;
        this.published_date = published_date;
        this.quantity = quantity;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ISBN: " + this.getISBN() + "\n" +
                "Title: " + this.getTitle() + "\n" +
                "Price: " + this.getPrice() + "\n" +
                "Category: " + this.getCategory() + "\n" +
                "Published date: " + this.getPublished_date() + "\n" +
                "Quantity: " + this.getQuantity() + "\n";
    }
}
