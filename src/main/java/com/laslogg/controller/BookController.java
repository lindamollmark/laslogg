package com.laslogg.controller;

import com.laslogg.core.model.Book;
import com.laslogg.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Linda on 2017-01-22.
 */
@Controller
public class BookController {

    @Autowired private BookService service;

    @RequestMapping(value = "login/bookpage/", method = RequestMethod.POST)
    public String book(@ModelAttribute("Book")Book newBook,
                      ModelMap modell){

        service.addBook(newBook);

        return "bookpage";

    }
}
