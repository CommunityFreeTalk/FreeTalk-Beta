package com.example.freetalk.community.dto;

import com.example.freetalk.community.entity.Comment;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentResp {

    private Long com_id;

    private Long w_id;

    private Long com_u_id;

    private String com_contents;

    private String indate;

    private String status;

    public CommentResp(Comment comment){
        this.com_id = comment.getCom_id();
        this.w_id = comment.getW_id();
        this.com_u_id = comment.getCom_u_id();
        this.com_contents = comment.getCom_contents();
        this.indate = comment.getIndate();
        this.status = comment.getStatus();
    }

}
