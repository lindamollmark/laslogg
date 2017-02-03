package com.laslogg.core.service;

import com.laslogg.core.model.Book;
import com.laslogg.persistens.BookDao;
import com.laslogg.persistens.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Linda on 2017-02-03.
 */
@Service
public class BookService {


    @Autowired
    private BookDao dao;

    public void addBook(Book newBook) {
        BookEntity book = new BookEntity();
        book.setName(newBook.getName());
        dao.save(book);

    }
}
