package com.example.freetalk.community.controller;

import com.example.freetalk.community.dto.ResultGroupDTO;
import com.example.freetalk.community.service.impl.SearchService;
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
public class SearchController {
    private final SearchService ss;


    @GetMapping("/search/search")
    public String search(@RequestParam String keyword, Model model){
        String[] keywordList  = keyword.split(" ");
        List<String> keywords = Arrays.stream(keywordList).collect(Collectors.toList());
        List<ResultGroupDTO> list = ss.selectByHashTag(keywordList);
        model.addAttribute("keywords",keywords);
        model.addAttribute("keyword",keyword);
        model.addAttribute("communityList",list);
        return "search";
    }
}
