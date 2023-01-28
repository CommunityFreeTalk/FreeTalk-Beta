package com.example.freetalk.community.entity;

import com.example.freetalk.oauth2.entity.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ht")
@ToString
public class HashTag {

    @Id
    @Column(name = "ht_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "ht_name")
    private String name;

    @Builder
    public HashTag(String name){
        this.name = name;
    }
}
