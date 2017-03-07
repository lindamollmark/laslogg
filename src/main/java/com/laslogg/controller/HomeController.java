package com.laslogg.controller;

import com.laslogg.core.model.Book;
import com.laslogg.core.model.User;
import com.laslogg.core.service.BookService;
import com.laslogg.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Scope("session")
@SessionAttributes("user")
@RequestMapping()
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/")
    public String home() {
        return "start";
    }

    @RequestMapping(value = "login/", method = RequestMethod.POST)
    public String executeLogin(HttpServletRequest request, Model model, @ModelAttribute("User") User user) {

        try {
            Boolean isValidUser = userService.isValidUser(user.getUsername(), user.getPassword());
            if (isValidUser) {
                User theUser = userService.getUser(user.getUsername(), user.getPassword());
                request.getSession().setAttribute("user", theUser);
                model.addAttribute("user", theUser);
                List<Book> bookList = bookService.getBookList(theUser);
                model.addAttribute("books", bookList);
                return "bookpage";

            } else {

                request.setAttribute("message", "Invalid credentials!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "start";
    }

    @RequestMapping(value = "newUser/", method = RequestMethod.POST)
    public ModelAndView addNewUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("User") User user) {
        ModelAndView model = null;
        try {
            boolean isValidUser = userService.addUser(user.getUsername(), user.getPassword());
            if (isValidUser) {
                System.out.println("Din användare är nu registrerad");
                model = new ModelAndView("start");
                request.setAttribute("message", "Användarkontot är nu skapat!");
            } else {
                model = new ModelAndView("newUser");
                model.addObject("User", user);
                request.setAttribute("message", "Användarnamnet upptaget");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

}
