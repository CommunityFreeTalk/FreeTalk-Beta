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

    private String communityName;

    private String hashTag;
    private String thumb;

    public Community toEntity(){
        return Community.builder()
                .name(communityName)
                .status("created")
                .image(thumb)
                .build();
    }
}
