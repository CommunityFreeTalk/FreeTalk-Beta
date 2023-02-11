package com.example.freetalk.community.dto;

import com.example.freetalk.community.entity.Comment;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDto {

    private Long com_id;

    private Long w_id;

    private Long com_u_id;
    private String com_contents;

    public Comment toEntity(){
        return Comment.builder()
                .com_id(com_id)
                .w_id(w_id)
                .com_u_id(com_u_id)
                .com_contents(com_contents)
                .status("created")
                .build();
    }



}
