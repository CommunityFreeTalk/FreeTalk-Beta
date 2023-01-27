package com.example.freetalk.community.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="cm")
@ToString
public class Community {

    @Id
    @Column(name = "c_key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "c_name")
    private String communityName;
    @Column(nullable = false,name = "img")
    private String thumb;

    @Column(name = "status")
    private String status;


    @Builder
    public Community(String communityName,String thumb,String status){
        this.communityName= communityName;
        this.thumb = thumb;
        this.status = status;
    }
}
