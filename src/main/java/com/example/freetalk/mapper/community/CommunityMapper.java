package com.example.freetalk.mapper.community;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CommunityMapper {

    public List<HashMap<String,String>> selectBySingleHashTag(String keyword);
}
