package com.example.freetalk.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

@Controller
//@RequiredArgsConstructor
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }



    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/search")
    @ResponseBody
    public String search(@RequestParam String keyword){
        String[] keywords  = keyword.split(" ");
        return keyword;

    }
}
