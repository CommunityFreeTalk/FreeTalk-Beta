package com.example.freetalk.oauth2.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagRelationMapper {

    int insertTagRelation(Long ht_id,Long c_key);


}
