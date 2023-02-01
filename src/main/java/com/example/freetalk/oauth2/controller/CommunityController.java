package com.example.freetalk.oauth2.controller;

import com.example.freetalk.oauth2.dto.CommunityDto;
import com.example.freetalk.oauth2.service.CommunityService;
import com.example.freetalk.oauth2.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService cs;

    private final PictureService ps;

    @PostMapping("/addCommunity")
    public @ResponseBody String addCommunity(CommunityDto communityDto){
        System.out.println("controller"+ communityDto);
        return cs.insertCom(communityDto);
    }

    @PostMapping("/pictures")
    public String insertPictures(@RequestParam("fileData") MultipartFile fileData) throws IOException {
        return ps.uploadPic(fileData);
    }
}
