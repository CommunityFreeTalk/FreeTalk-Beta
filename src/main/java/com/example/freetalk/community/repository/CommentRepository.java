package com.example.freetalk.community.repository;

import com.example.freetalk.community.dto.CommentDto;
import com.example.freetalk.community.dto.CommentResp;
import com.example.freetalk.mapper.community.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final CommentMapper cm;

    public List<CommentResp> findAllComment(Long w_id){
        return cm.findAllComment(w_id);
    }

    public int insertComment(CommentDto commentDto){
        return cm.insertComment(commentDto);
    }
}
