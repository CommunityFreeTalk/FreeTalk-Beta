package com.example.freetalk.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController {

    @GetMapping("/search/search")
    public String search(@RequestParam String keyword, Model model){
        String[] keywordList  = keyword.split(" ");
        List<String> keywords = Arrays.stream(keywordList).collect(Collectors.toList());
        model.addAttribute("keywords",keywords);
        model.addAttribute("keyword",keyword);
        return "search";
    }
}
