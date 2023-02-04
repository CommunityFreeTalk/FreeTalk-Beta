package com.example.freetalk.community.service.impl;

import com.example.freetalk.community.dto.*;
import com.example.freetalk.community.entity.HashTag;
import com.example.freetalk.community.entity.Like;
import com.example.freetalk.community.entity.Posting;
import com.example.freetalk.community.repository.*;
import com.example.freetalk.community.service.CommunityService;
import com.example.freetalk.oauth2.dto.SessionUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final TagRelationRepository tagRelationRepository;
    private final CommunityJPARepository communityJPARepository;
    private final HashTagJPARepository hashTagJPARepository;

    private final PostingJPARepository postingJPARepository;
    private final LikeJPARepository likeJPARepository;
    private final DislikeJPARepository dislikeJPARepository;

    @Override
    @Transactional
    public String addCommunity(CommunityDTO dto){
        if (communityJPARepository.existsByCommunityName(dto.getCommunityName()))return "failed";
        String[] HashTags = dto.getHashTag().split(" ");
        CommunityResp cmResp = new CommunityResp(communityJPARepository.save(dto.toEntity()));
        for (String hashTag : HashTags){
            HashTagResp hashTagResp = null;
            try {
                hashTagResp = new HashTagResp(hashTagJPARepository.findByName(hashTag));
            }catch (Exception e){}
            if (hashTagResp==null){
                hashTagResp = new HashTagResp(hashTagJPARepository.save(HashTag.builder().name(hashTag).build()));
            }
            HashMap<String,Integer> map = new HashMap<>();
            map.put("c_key",(int)cmResp.getId());
            map.put("ht_id",(int)hashTagResp.getId());
            //JPA
            int result = tagRelationRepository.insertTagRelation(map);
            if (result<1)return "failed";
        }
        return "success";
    }

    @Override
    public String addPosting(PostingDTO dto, SessionUserDto user) {
        dto.setU_id(user.getId());
        try {
            Posting posting = postingJPARepository.save(dto.toEntity());
            return "success";
        }catch (Exception e){
            return "failed";
        }
    }

    @Override
    public String like(LikeDTO dto, SessionUserDto user) {
        dto.setUserID(user.getId());
        dto.setTableTypeByEnum();
        if(likeJPARepository.existsById(dto.toJPAEntity())){
            return "alreadyLiked";
        }
        if(dislikeJPARepository.existsById(dto.toJPAEntity())){
            return "alreadyDisliked";
        }

        if (dto.getType().equals("like")){
            System.out.println(dto.toLikeEntity().getId().toString());
                likeJPARepository.save(dto.toLikeEntity());
                return "success";
        }else if ((dto.getType().equals("dislike"))){
            System.out.println(dto.toDislikeEntity().getId().toString());
                dislikeJPARepository.save(dto.toDislikeEntity());
                return "success";
        }else return "failed";
    }


}
