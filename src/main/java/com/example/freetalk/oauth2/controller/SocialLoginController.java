package com.example.freetalk.oauth2.controller;

import com.example.freetalk.oauth2.dto.SessionUserDto;
import com.example.freetalk.oauth2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class SocialLoginController {

    private final HttpSession httpSession;

    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {

        SessionUserDto user = (SessionUserDto) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userEmail", user.getEmail());
        }
        return "index";
    }

//    @GetMapping("/test")
//    public @ResponseBody String test(@AuthenticationPrincipal OAuth2User principal) {
//
//        return principal.getAttribute("email");
//    }



}