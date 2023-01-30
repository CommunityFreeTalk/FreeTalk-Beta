package com.example.freetalk.oauth2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name="cm")
public class Community {

    @Id
    @Column(name = "c_key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "img")
    private String image;


}
