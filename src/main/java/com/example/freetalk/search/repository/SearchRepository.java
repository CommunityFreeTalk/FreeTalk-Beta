package com.example.freetalk.search.repository;

import com.example.freetalk.mapper.community.SearchMapper;
import com.example.freetalk.search.dto.ResultGroupDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchRepository {

    private final SearchMapper cm;

    public List<ResultGroupDTO> selectBySingleHashTag(String keyword){
        return cm.selectBySingleHashTag(keyword);
    }
}
