package com.example.freetalk.community.dto;

import com.example.freetalk.community.entity.Posting;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostingResp {

    private Long w_id;
    private Long u_id;
    private Long c_key;
    private String w_title;
    private String w_contents;
    private String inDate;
    private String status;
    private Long views;




    public PostingResp(Posting posting) {
        this.w_id = posting.getW_id();
        this.u_id = posting.getU_id();
        this.c_key = posting.getC_key();
        this.w_title = posting.getW_title();
        this.w_contents = posting.getW_contents();
        this.inDate = posting.getInDate();
        this.status = posting.getStatus();
        this.views = posting.getViews();
    }



}
