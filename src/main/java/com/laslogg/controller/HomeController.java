package com.laslogg.controller;

import com.laslogg.core.model.User;
import com.laslogg.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Linda on 2017-01-22.
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String home() {
        return "start";
    }

    @RequestMapping(value = "login/", method = RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("User") User user) {
        ModelAndView model = null;
        try {
            boolean isValidUser = userService.isValidUser(user.getUsername(), user.getPassword());
            if (isValidUser) {
                System.out.println("User Login Successful");
                request.setAttribute("loggedInUser", user.getUsername());
                model = new ModelAndView("bookpage");
            } else {
                model = new ModelAndView("login");
                model.addObject("loginBean", user);
                request.setAttribute("message", "Invalid credentials!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "newUser/", method = RequestMethod.POST)
    public ModelAndView addNewUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("User") User user) {
        ModelAndView model = null;
        try {
            boolean isValidUser = userService.addUser(user.getUsername(), user.getPassword());
            if (isValidUser) {
                System.out.println("Din användare är nu registrerad");
                model = new ModelAndView("/");
            } else {
                model = new ModelAndView("login");
                model.addObject("loginBean", user);
                request.setAttribute("message", "Invalid credentials!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

}
