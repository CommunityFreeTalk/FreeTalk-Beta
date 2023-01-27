package com.example.freetalk.community.repository;

import com.example.freetalk.mapper.community.TagRelationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@RequiredArgsConstructor
public class TagRelationRepository {
    private final TagRelationMapper tm;
    public int insertTagRelation (HashMap<String,Integer> hashMap){
        return tm.addTagRelation(hashMap);
    }
}
