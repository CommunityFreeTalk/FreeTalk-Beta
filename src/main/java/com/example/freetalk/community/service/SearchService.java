package com.example.freetalk.community.service;

import com.example.freetalk.community.dto.ResultGroupDTO;

import java.util.List;

public interface SearchService {

    public List<ResultGroupDTO> selectByHashTag(String[] keywords);
}
