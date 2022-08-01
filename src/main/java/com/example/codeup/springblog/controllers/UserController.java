package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.reposotories.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }
}
