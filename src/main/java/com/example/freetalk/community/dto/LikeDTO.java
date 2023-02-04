package com.example.freetalk.community.dto;

import com.example.freetalk.community.entity.Like;
import com.example.freetalk.community.entity.LikeJPAEntity;
import com.example.freetalk.community.entity.Dislike;
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


    public void setTableTypeByEnum(){
        if (this.tableType.equals("posting")) {
            this.tableType = POSTING.getTableName();
        }
        else if (this.tableType.equals("comment")){
            this.tableType =COMMENT.getTableName();
        }
    }

    public Like toLikeEntity(){
        return new Like(LikeJPAEntity.builder()
                .tableType(tableType)
                .type_id(tableType_id)
                .u_id(userID).build());
    }

    public Dislike toDislikeEntity(){
        return new Dislike(LikeJPAEntity.builder()
                .tableType(tableType)
                .type_id(tableType_id)
                .u_id(userID).build());
    }

    public LikeJPAEntity toJPAEntity(){
        return new LikeJPAEntity(userID,tableType,tableType_id);
    }


}
