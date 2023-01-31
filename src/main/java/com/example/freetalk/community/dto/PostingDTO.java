package com.example.freetalk.community.dto;

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

}
