package com.laslogg.persistens.dao;

import com.laslogg.persistens.entity.BookEntity;

import java.util.List;

public interface BookDao {

    public void save(BookEntity book);
    public List<BookEntity> getUsersBook(int id);
}
