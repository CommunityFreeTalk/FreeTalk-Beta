package com.example.freetalk.community.dto;

import lombok.*;

import static com.example.freetalk.community.entity.TableType.COMMENT;
import static com.example.freetalk.community.entity.TableType.POSTING;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LikeDTO {

    private String type;
    private String tableType;
    private Long tableType_id;
    private Long userID;


    public void setTableType(){
        if (this.tableType.equals("posting")) {
            this.tableType = POSTING.getTableName();
        }
        else if (this.tableType.equals("comment")){
            this.tableType =COMMENT.getTableName();
        }
    }

}
