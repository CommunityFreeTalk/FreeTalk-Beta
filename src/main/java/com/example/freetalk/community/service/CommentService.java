package com.example.freetalk.community.service;

import com.example.freetalk.community.dto.CommentDto;
import com.example.freetalk.community.dto.CommentResp;
import com.example.freetalk.community.repository.CommentRepository;
import com.example.freetalk.community.repository.PostingJPARepository;
import com.example.freetalk.oauth2.dto.SessionUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository cr;
    private final PostingJPARepository pr;

    public List<CommentResp> findAllComment(Long w_id) {
        return cr.findAllComment(w_id);
    }

    public String insertComment(CommentDto commentDto) {
        if(commentDto.getCom_contents().length()!=0||!commentDto.getCom_contents().equals("")){
            if(cr.insertComment(commentDto)>0){
                return "success";
            }
        }
        return "failed";
    }


    @Transactional
    public String deleteComment(CommentDto commentDto, SessionUserDto user) {
        Long com_u_id = cr.findCommentById(commentDto.getCom_u_id());
        if (com_u_id==user.getId()) {
            if (cr.deleteComment(commentDto.getCom_id()) > 0) {
                return "success";
            }
        }
        return "failed";
    }

    @Transactional
    public String updateComment(CommentDto commentDto, SessionUserDto user){
        Long com_u_id = cr.findCommentById(commentDto.getCom_u_id());
        if (com_u_id==user.getId()) {
            if (cr.updateComment(commentDto) > 0) {
                return "success";
            }
        }
        return "failed";
    }



}
