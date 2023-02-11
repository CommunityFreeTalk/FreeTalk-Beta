package com.example.freetalk.mapper.community;

import com.example.freetalk.community.dto.CommentDto;
import com.example.freetalk.community.dto.CommentResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentResp> findAllComment(Long w_id);
    Long findCommentById(Long com_id);

    int insertComment(CommentDto commentDto);

    int updateComment(CommentDto commentDto);

    int deleteComment(Long com_id);


}
