package com.example.freetalk.search.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultGroupDTO {
    private String img;
    private String hashTag;
    private String c_name;
    private String c_key;
    private String status;

    public void toTag(){
        String[] getNames = hashTag.split(",");
        StringBuilder sb = new StringBuilder();
        for (String str : getNames){
            sb.append("#"+str+" ");
        }
        setHashTag(sb.toString());
    }
}
