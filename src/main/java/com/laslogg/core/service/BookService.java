package com.laslogg.core.service;

import com.laslogg.core.model.Book;
import com.laslogg.persistens.dao.BookDao;
import com.laslogg.persistens.entity.BookEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Linda on 2017-02-03.
 */
@Service
public class BookService {

    ApplicationContext context =
            new ClassPathXmlApplicationContext("Spring-Module.xml");

    private BookDao dao= (BookDao) context.getBean("bookDao");

    public void addBook(Book newBook) {
        BookEntity book = new BookEntity();
        book.setName(newBook.getName());
        book.setAuthor(newBook.getAuthor());
        book.setNumberOfPages(newBook.getNumberOfPages());
        dao.save(book);

    }
}
