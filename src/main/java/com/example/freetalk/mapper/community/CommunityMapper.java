package com.example.freetalk.mapper.community;

import com.example.freetalk.search.dto.ResultGroupDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

    public List<ResultGroupDTO> selectBySingleHashTag(String keyword);
}
