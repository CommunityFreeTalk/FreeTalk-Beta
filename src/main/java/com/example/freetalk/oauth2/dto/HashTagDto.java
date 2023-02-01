package com.example.freetalk.oauth2.dto;

import com.example.freetalk.oauth2.entity.HashTag;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class HashTagDto {

    private Long ht_id;

    private String ht_name;

    public HashTagDto(String ht_name) {
        this.ht_name = ht_name;
    }

    public HashTag toEntity(String ht_name) {
        return HashTag.builder()
                .name(ht_name)
                .build();
    }


}
