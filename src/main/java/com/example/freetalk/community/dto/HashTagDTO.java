package com.example.freetalk.community.dto;

import com.example.freetalk.community.entity.HashTag;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class HashTagDTO {
    private String name;


    public HashTag toEntity(){
        return HashTag.builder().name(name).build();
    }
}
