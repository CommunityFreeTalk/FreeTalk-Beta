package com.example.freetalk.search.service;

import com.example.freetalk.mapper.community.CommunityMapper;
import com.example.freetalk.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository sr;

    public List<HashMap<String ,String>> selectByHashTag(String[] keywords){
        if (keywords.length==1){
            return sr.selectBySingleHashTag(keywords[0]);
        }else return null;
    }


}
