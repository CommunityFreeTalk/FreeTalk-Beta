package com.example.freetalk.community.service.impl;

import com.example.freetalk.community.dto.ResultGroupDTO;
import com.example.freetalk.community.repository.SearchRepository;
import com.example.freetalk.community.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchRepository sr;

    @Override
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
