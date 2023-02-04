package com.example.freetalk.community.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@ToString

public class LikeJPAEntity implements Serializable {


    @Column(name = "u_id")
    private Long u_id;

    @Column(name = "table_type")
    private String tableType;

    @Column(name = "type_id")
    private Long type_id;

    @Builder
    public LikeJPAEntity(Long u_id, String tableType, Long type_id) {
        this.u_id = u_id;
        this.tableType = tableType;
        this.type_id = type_id;
    }
}
