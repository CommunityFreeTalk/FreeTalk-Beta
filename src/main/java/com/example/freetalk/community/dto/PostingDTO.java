package com.example.freetalk.community.dto;

import com.example.freetalk.community.entity.Posting;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PostingDTO {

    private String postName;
    private String content;
    private Long c_key;
    private Long u_id;

    public Posting toEntity(){
        return Posting.builder()
                .c_key(c_key)
                .u_id(u_id)
                .w_contents(content)
                .w_title(postName).build();
    }
}
