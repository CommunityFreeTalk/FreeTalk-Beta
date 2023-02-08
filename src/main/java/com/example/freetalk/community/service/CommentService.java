package com.example.freetalk.community.service;

import com.example.freetalk.community.dto.CommentDto;
import com.example.freetalk.community.dto.CommentResp;
import com.example.freetalk.community.repository.CommentRepository;
import com.example.freetalk.community.repository.PostingJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository cr;
    private final PostingJPARepository pr;

    public List<CommentResp> findAllComment(Long w_id){
        return cr.findAllComment(w_id);
    }

    public int insertComment(CommentDto commentDto){
        return cr.insertComment(commentDto);
    }





}
