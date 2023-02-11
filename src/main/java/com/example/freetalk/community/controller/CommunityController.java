package com.example.freetalk.community.controller;

import com.example.freetalk.community.dto.*;
import com.example.freetalk.community.service.CommentService;
import com.example.freetalk.community.service.impl.CommunityServiceImpl;
import com.example.freetalk.community.service.PictureService;
import com.example.freetalk.oauth2.dto.SessionUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class CommunityController {

    private final PictureService pics;
    private final CommunityServiceImpl cs;

    private final CommentService commentService;

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

        return cs.addCommunity(dto);
    }

    @PostMapping("/posting")
    public String writing(PostingDTO dto, HttpSession session){
        SessionUserDto user = (SessionUserDto)session.getAttribute("user");
        return cs.addPosting(dto,user);
    }



    @PostMapping("/Like")
    private String like(LikeDTO dto,HttpSession session){
        SessionUserDto user = (SessionUserDto)session.getAttribute("user");
        return "success";
    }

    @PostMapping("/view/commentPost")
    public String insertComment(CommentDto commentDto){
        return commentService.insertComment(commentDto);
    }


    @PostMapping("/view/deleteComment")
    public String deleteComment(CommentDto commentDto,HttpSession session){
        SessionUserDto user = (SessionUserDto)session.getAttribute("user");
        return commentService.deleteComment(commentDto,user);
    }

    @PostMapping("/view/updateComment")
    public String updateComment(CommentDto commentDto, HttpSession session){
        SessionUserDto user = (SessionUserDto)session.getAttribute("user");
        return commentService.updateComment(commentDto,user);
    }
}
