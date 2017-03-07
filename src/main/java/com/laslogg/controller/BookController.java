package com.laslogg.controller;

import com.laslogg.core.model.Book;
import com.laslogg.core.model.User;
import com.laslogg.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

@Controller
@Scope("session")
@SessionAttributes("user")
public class BookController {

    @Autowired private BookService service;

    @RequestMapping(value = "login/bookpage/", method = RequestMethod.POST)
    public String book(@ModelAttribute("Book")Book newBook,
                       Model model){
        Map modelMap = model.asMap();
        newBook.setUser((User)modelMap.get("user"));
        service.addBook(newBook);

        return "bookpage";
    }
}
