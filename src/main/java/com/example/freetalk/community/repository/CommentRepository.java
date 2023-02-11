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

    public Long findCommentById(Long com_id){
        return cm.findCommentById(com_id);
    }

    public int insertComment(CommentDto commentDto){
        return cm.insertComment(commentDto);

    }

    public int deleteComment(Long com_id){
        return cm.deleteComment(com_id);
    }

    public int  updateComment(CommentDto commentDto){
        return cm.updateComment(commentDto);
    }
}
