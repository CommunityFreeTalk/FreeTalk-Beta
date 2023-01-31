package com.example.freetalk.community.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="wr")
@ToString
public class Posting {

    @Id
    @Column(name = "w_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long w_id;
    @Column(nullable = false,name = "u_id")
    private Long u_id;
    @Column(nullable = false,name = "c_key")
    private Long c_key;
    @Column(nullable = false,name = "w_title")
    private String w_title;
    @Column(nullable = false,name = "w_contents")
    private String w_contents;
    @Column(name = "indate")
    private String inDate;
    @Column(name = "status")
    private String status;


    @Builder
    public Posting(Long u_id, Long c_key, String w_title, String w_contents) {
        this.u_id = u_id;
        this.c_key = c_key;
        this.w_title = w_title;
        this.w_contents = w_contents;
    }
}
