package com.example.freetalk.oauth2.repository;

import com.example.freetalk.oauth2.dto.HashTagDto;
import com.example.freetalk.oauth2.mapper.HashTagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HashTagRepository {

    private final HashTagMapper hm;

    public int insertHashTag(HashTagDto hashTagDto){
        return hm.insertHashTag(hashTagDto);
    }

    public String selectHashTag(HashTagDto hashTagDto){
        return hm.selectHashTag(hashTagDto);
    }

    public Long selectHashId(HashTagDto hashTagDto){
        return hm.selectHashId(hashTagDto);
    }
}
