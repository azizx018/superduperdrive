package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    public String getHomePage(Model model) {
        return "home";
    }


}
