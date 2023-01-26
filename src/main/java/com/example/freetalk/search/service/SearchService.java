package com.example.freetalk.search.service;

import com.example.freetalk.search.dto.ResultGroupDTO;
import com.example.freetalk.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository sr;

    public List<ResultGroupDTO> selectByHashTag(String[] keywords){
        if (keywords.length==1){
            List<ResultGroupDTO> list = sr.selectBySingleHashTag(keywords[0]);
            if (list.get(0)==null){
                list= new ArrayList<>();
                return list;
            }else {
                return sr.selectBySingleHashTag(keywords[0]);
            }
            //다중 검색
        }else return new ArrayList<>();
    }


}
