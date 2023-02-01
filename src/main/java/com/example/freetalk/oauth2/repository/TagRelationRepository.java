package com.example.freetalk.oauth2.repository;

import com.example.freetalk.oauth2.mapper.TagRelationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor
@Repository
public class TagRelationRepository {

    private final TagRelationMapper tm;

    public int insertTagRelation(Long id, Long key){
        return tm.insertTagRelation(id,key);
    }
}
