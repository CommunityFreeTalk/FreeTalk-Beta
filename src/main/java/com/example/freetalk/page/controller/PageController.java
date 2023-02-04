package com.example.freetalk.page.controller;

import com.example.freetalk.community.dto.PostingResp;
import com.example.freetalk.community.entity.Posting;
import com.example.freetalk.community.service.CommunityService;
import com.example.freetalk.community.service.impl.CommunityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor
public class PageController {

    private final CommunityServiceImpl communityServiceimpl;


    @GetMapping("/socialLogin")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/search")
    @ResponseBody
    public String search(@RequestParam String keyword) {
        String[] keywords = keyword.split(" ");
        return keyword;
    }

    @GetMapping("/Logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }



    @GetMapping("/addCommunity")
    public String community(){
        return "addCommunity";
    }

    @GetMapping("/sidemenu")
    public String side(){
        return "side";
    }

    @GetMapping("/community/communityPage")
    public String communityPage(@RequestParam String c_key){
        System.out.println(c_key);
        return "index";
    }

    @GetMapping("/posting")
    public String writing(Model model){
        model.addAttribute("c_key",1);//CommunityPage 완성시 수정
        return "writing";
    }

    @GetMapping("/view")
    public String view(@RequestParam("w_id") Long index, Model model){
        PostingResp view = communityServiceimpl.selectPosting(index);
        System.out.println(view.toString());

        model.addAttribute("view",view);
        return "post";
    }



}

