package com.example.film.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/Film")
    public String index()  {
        return "forward:loginandregister.html";
    }
}

