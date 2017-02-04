package com.laslogg.persistens.entity;

import javax.persistence.Entity;

/**
 * Created by Linda on 2017-02-03.
 */
@Entity
public class BookEntity {

    int id;
    String name;
    int numberOfPages;
    String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
