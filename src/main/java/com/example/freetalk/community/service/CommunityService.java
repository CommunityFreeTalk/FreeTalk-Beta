package com.example.freetalk.community.service;

import com.example.freetalk.community.dto.CommunityDTO;
import com.example.freetalk.community.dto.PostingDTO;
import com.example.freetalk.community.dto.PostingResp;
import com.example.freetalk.oauth2.dto.SessionUserDto;

public interface CommunityService {
    public String addCommunity(CommunityDTO dto);

    public String addPosting(PostingDTO dto, SessionUserDto user);

    public PostingResp selectPosting(Long index);
}
