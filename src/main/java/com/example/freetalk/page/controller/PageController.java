package com.example.freetalk.page.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PageController {

//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }



    @GetMapping("/socialLogin")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/search")
    @ResponseBody
    public String search(@RequestParam String keyword){
        String[] keywords  = keyword.split(" ");
        return keyword;

    }

    @GetMapping("/addCommunity")
    public String addCommunity(){
        return "addCommunity";
    }
}
