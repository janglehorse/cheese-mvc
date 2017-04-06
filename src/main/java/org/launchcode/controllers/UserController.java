package org.launchcode.controllers;

import org.launchcode.models.Data.UserDao;
import org.launchcode.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by adminbackup on 3/27/17.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDao.findAll());

        return "user/user-index";

    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "User Signup");
        model.addAttribute(new User());
        return "user/add-user";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddForm(Model model,
                                 @ModelAttribute @Valid User user,
                                 Errors errors) {

        if (errors.hasErrors()){
            model.addAttribute("title", "User Signup");
            //Studio 3.9 instructions say to pass user to the model because "The user object contains the error messages associated with validation."
            //Error messages behave as expected without doing this. Why?
            user.setPassword("");
            return "user/add-user";
        }

        userDao.save(user);
        model.addAttribute("title", "User Page");
        model.addAttribute("success", "Welcome, " + user.getUsername() + "!");
        model.addAttribute(user);
        return "user/success";
    }
}
