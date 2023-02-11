package com.example.freetalk.community.entity;

import com.example.freetalk.oauth2.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "com")
@Builder
@ToString
public class Comment {

    @Id
    @Column(name = "com_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long com_id;

    @Column(name = "w_id")
    private Long w_id;

    @Column(name = "com_u_id")
    private Long com_u_id;

    @Column(nullable = false,name = "com_contents")
    private String com_contents;

    @Column(name = "indate")
    private String indate;

    @Column(name = "status")
    private String status;





}
