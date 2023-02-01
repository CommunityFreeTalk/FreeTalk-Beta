package com.example.freetalk.oauth2.dto;

import com.example.freetalk.oauth2.entity.Community;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommunityResp {

    private Long id;

    private String name;

    private String status;

    private String image;

    public CommunityResp(Community community){
        this.id = community.getId();
        this.name = community.getName();
        this.status = community.getStatus();
        this.image = community.getImage();
    }
}
