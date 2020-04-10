package com.kamil.springapi.model;

import javax.persistence.*;

@Entity(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_id;
    private String author_first_name;
    private String author_last_name;

    public Author() {

    }

    public Author(int author_id, String author_first_name, String author_last_name) {
        this.author_id = author_id;
        this.author_first_name = author_first_name;
        this.author_last_name = author_last_name;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_first_name() {
        return author_first_name;
    }

    public void setAuthor_first_name(String author_first_name) {
        this.author_first_name = author_first_name;
    }

    public String getAuthor_last_name() {
        return author_last_name;
    }

    public void setAuthor_last_name(String author_last_name) {
        this.author_last_name = author_last_name;
    }
}
