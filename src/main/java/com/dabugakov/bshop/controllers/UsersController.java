package com.dabugakov.bshop.controllers;

import com.dabugakov.bshop.dao.UserDao;
import com.dabugakov.bshop.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by DABugakov on 27.11.2015.
 */

@Controller
public class UsersController {
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public ModelAndView getUsers(Model model) {
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users);
        return new ModelAndView("userspage");
    }


    @RequestMapping(value = "/users/add.do", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("personAttribute", new User());
        return "addedpage";
    }

}
