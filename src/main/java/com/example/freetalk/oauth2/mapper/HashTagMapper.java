package com.example.freetalk.oauth2.mapper;

import com.example.freetalk.oauth2.dto.HashTagDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HashTagMapper {

    int insertHashTag(HashTagDto hashTagDto);

    String selectHashTag(HashTagDto hashTagDto);
    Long selectHashId(HashTagDto hashTagDto);
}
