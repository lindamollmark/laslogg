package com.laslogg.core.service;

import com.laslogg.core.model.Book;
import com.laslogg.persistens.dao.BookDao;
import com.laslogg.persistens.entity.BookEntity;
import com.laslogg.persistens.entity.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

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
        UserEntity ue = new UserEntity();
        book.setUser(ue.fromModel(newBook.getUser()));
        dao.save(book);

    }
}
