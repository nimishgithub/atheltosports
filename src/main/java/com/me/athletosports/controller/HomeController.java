package com.me.athletosports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home.htm")
    public String homePageGet() {
        return "home";
    }
}
