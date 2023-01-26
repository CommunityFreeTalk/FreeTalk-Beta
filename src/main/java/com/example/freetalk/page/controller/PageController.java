package com.example.freetalk.page.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("/socialLogin")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/summerNote")
    public String first() {
        return "SummerNote";
    }
}
