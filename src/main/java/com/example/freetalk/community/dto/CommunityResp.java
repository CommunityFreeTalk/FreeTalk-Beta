package com.example.freetalk.community.dto;

import com.example.freetalk.community.entity.Community;
import com.example.freetalk.community.entity.HashTag;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommunityResp {
    private long id;
    private String name;
    private String status;
    private String img;

    public CommunityResp(Community community){
        this.id=community.getId();
        this.name=community.getCommunityName();
        this.img=community.getThumb();
        this.status=community.getStatus();
    }
}
