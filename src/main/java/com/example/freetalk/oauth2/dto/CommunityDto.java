package com.example.freetalk.oauth2.dto;

import com.example.freetalk.oauth2.entity.Community;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommunityDto {

    private String name;

    private String HashTag;
    private String image;

    public Community toEntity(){
        return Community.builder()
                .name(name)
                .status("created")
                .image(image)
                .build();
    }
}
