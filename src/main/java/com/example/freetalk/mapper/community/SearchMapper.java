package com.example.freetalk.mapper.community;

import com.example.freetalk.community.dto.ResultGroupDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    List<ResultGroupDTO> selectBySingleHashTag(String keyword);

    List<ResultGroupDTO> selectByHashTagList(List<String> list);

}
