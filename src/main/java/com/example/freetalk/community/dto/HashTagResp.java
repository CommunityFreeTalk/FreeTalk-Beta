package com.example.freetalk.community.dto;

import com.example.freetalk.community.entity.HashTag;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HashTagResp {
    private long id;
    private String name;

    public HashTagResp(HashTag hashTag){
        this.id=hashTag.getId();
        this.name=hashTag.getName();
    }
}
