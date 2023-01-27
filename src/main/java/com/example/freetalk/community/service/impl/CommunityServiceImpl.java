package com.example.freetalk.community.service.impl;

import com.example.freetalk.community.dto.CommunityDTO;
import com.example.freetalk.community.dto.CommunityResp;
import com.example.freetalk.community.dto.HashTagResp;
import com.example.freetalk.community.entity.HashTag;
import com.example.freetalk.community.repository.CommunityJPARepository;
import com.example.freetalk.community.repository.HashTagJPARepository;
import com.example.freetalk.community.repository.TagRelationRepository;
import com.example.freetalk.community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final TagRelationRepository tr;
    private final CommunityJPARepository cmJPARepo;
    private final HashTagJPARepository htJPARepo;

    @Override
    @Transactional
    public String addCommunity(CommunityDTO dto){
        if (cmJPARepo.existsByCommunityName(dto.getCommunityName()))return "failed";
        String[] HashTags = dto.getHashTag().split(" ");
        CommunityResp cmResp = new CommunityResp(cmJPARepo.save(dto.toEntity()));
        for (String hashTag : HashTags){
            HashTagResp hashTagResp = null;
            try {
                hashTagResp = new HashTagResp(htJPARepo.findByName(hashTag));
            }catch (Exception e){}
            if (hashTagResp==null){
                hashTagResp = new HashTagResp(htJPARepo.save(HashTag.builder().name(hashTag).build()));
            }
            HashMap<String,Integer> map = new HashMap<>();
            map.put("c_key",(int)cmResp.getId());
            map.put("ht_id",(int)hashTagResp.getId());
            System.out.println(map);
            int result =tr.insertTagRelation(map);
            if (result<1)return "failed";
        }
        return "success";
    }


}
