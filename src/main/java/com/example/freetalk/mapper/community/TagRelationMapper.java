package com.example.freetalk.mapper.community;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface TagRelationMapper {

    int addTagRelation (HashMap<String,Integer> hashMap);
}
