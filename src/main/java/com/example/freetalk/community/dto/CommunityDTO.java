package com.example.freetalk.community.dto;

import com.example.freetalk.community.entity.Community;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommunityDTO {
    private String communityName;
    private String thumb;
    private String HashTag;

    public Community toEntity(){
        return Community.builder()
                .communityName(communityName)
                .thumb(thumb)
                .status("created")
                .build();
    }
}
