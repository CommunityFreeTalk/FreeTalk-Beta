package com.example.freetalk.oauth2.service;

import com.example.freetalk.oauth2.dto.CommunityDto;
import com.example.freetalk.oauth2.dto.CommunityResp;
import com.example.freetalk.oauth2.dto.HashTagDto;
import com.example.freetalk.oauth2.mapper.TagRelationMapper;
import com.example.freetalk.oauth2.repository.CommunityRepository;
import com.example.freetalk.oauth2.repository.HashTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository cr;
    private final HashTagRepository hr;

    private final TagRelationMapper tm;

    @Transactional
    public String insertCom(CommunityDto communityDto) {
        System.out.println(communityDto.getCommunityName());

        if (!cr.findByName(communityDto.getCommunityName()).isPresent()) {
            CommunityResp communityResp = new CommunityResp(cr.save(communityDto.toEntity()));

            String[] hashTags = communityDto.getHashTag().split(" ");
            int result = 0;
            for(String hashTag : hashTags) {
                HashTagDto hashTagDto = new HashTagDto(hashTag);
                if (hr.selectHashTag(hashTagDto) == null) {
                    result += hr.insertHashTag(hashTagDto);
                    Long ht_id = hr.selectHashId(hashTagDto);
                    result += tm.insertTagRelation(ht_id, communityResp.getId());
                }
            }

            if(result>1){
                return "success";
            }else{
                return "failed";
            }


        }return "existed";
    }


}
