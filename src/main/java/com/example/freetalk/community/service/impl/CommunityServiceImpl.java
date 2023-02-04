package com.example.freetalk.community.service.impl;

import com.example.freetalk.community.dto.*;
import com.example.freetalk.community.entity.HashTag;
import com.example.freetalk.community.entity.Posting;
import com.example.freetalk.community.repository.CommunityJPARepository;
import com.example.freetalk.community.repository.HashTagJPARepository;
import com.example.freetalk.community.repository.PostingJPARepository;
import com.example.freetalk.community.repository.TagRelationRepository;
import com.example.freetalk.community.service.CommunityService;
import com.example.freetalk.oauth2.dto.SessionUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final TagRelationRepository tr;
    private final CommunityJPARepository cmJPARepo;
    private final HashTagJPARepository htJPARepo;

    private final PostingJPARepository pstJPARepo;

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
            //JPA
            int result =tr.insertTagRelation(map);
            if (result<1)return "failed";
        }
        return "success";
    }

    @Override
    public String addPosting(PostingDTO dto, SessionUserDto user) {
        dto.setU_id(user.getId());
        try {
            Posting posting = pstJPARepo.save(dto.toEntity());
            return "success";
        }catch (Exception e){
            return "failed";
        }

    }

    @Override
    public PostingResp selectPosting(Long index) {
        PostingResp resp = null;

        try{
            Optional<Posting> posting = pstJPARepo.findById(index);
            resp = new PostingResp(posting.get());
        }catch(Exception e){}

        return resp;
    }


}
