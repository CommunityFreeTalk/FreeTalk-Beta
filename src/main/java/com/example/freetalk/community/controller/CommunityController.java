package com.example.freetalk.community.controller;

import com.example.freetalk.community.dto.CommunityDTO;
import com.example.freetalk.community.dto.PostingDTO;
import com.example.freetalk.community.service.impl.CommunityServiceImpl;
import com.example.freetalk.community.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class CommunityController {

    private final PictureService pics;
    private final CommunityServiceImpl cs;

    @PostMapping("/pictures")
    public String insertPictures(@RequestParam("fileData") MultipartFile fileData) throws IOException {
        String str = pics.uploadPic(fileData);
        return str;
    }

    @PostMapping("/ePictures")
    public String insertEPictures(@RequestParam(value = "filedata") MultipartFile filedata) throws IOException {
        String str = pics.uploadPic(filedata);
        return str;
    }

    @PostMapping("/addCommunity")
    public String addCommunity(CommunityDTO dto){

        System.out.println(dto.toString());
        return cs.addCommunity(dto);
    }

    @PostMapping("/posting")
    public String writing(PostingDTO dto){
        return "success";
    }
}
