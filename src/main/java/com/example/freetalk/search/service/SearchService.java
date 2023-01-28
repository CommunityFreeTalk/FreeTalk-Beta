package com.example.freetalk.search.service;

import com.example.freetalk.search.dto.ResultGroupDTO;
import com.example.freetalk.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository sr;

    public List<ResultGroupDTO> selectByHashTag(String[] keywords){
        List<String> kws = Arrays.asList(keywords);
        List<ResultGroupDTO> list = sr.selectByHashTagList(kws);
            if (list==null){
                list= new ArrayList<>();
                return list;
            }else {
                for(ResultGroupDTO dto : list){
                    dto.toTag();
                }
            }
            return list;
    }
}
