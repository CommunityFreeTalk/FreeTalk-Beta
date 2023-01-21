package com.example.freetalk.search.repository;

import com.example.freetalk.mapper.community.CommunityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchRepository {

    private final CommunityMapper cm;

    public List<HashMap<String ,String >> selectBySingleHashTag(String keyword){
        return cm.selectBySingleHashTag(keyword);
    }
}
