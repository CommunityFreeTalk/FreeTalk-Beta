package com.example.freetalk.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequiredArgsConstructor
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
