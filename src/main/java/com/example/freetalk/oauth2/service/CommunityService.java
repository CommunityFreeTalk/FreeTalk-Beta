package com.example.freetalk.oauth2.service;

import com.example.freetalk.oauth2.dto.CommunityDto;
import com.example.freetalk.oauth2.entity.Community;
import com.example.freetalk.oauth2.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository cr;

    public String insertCom(CommunityDto communityDto){
        System.out.println("service"+communityDto);
        try{
            cr.save(communityDto.toEntity());
        }catch(Exception e){
            return "failed";
        }return "success";
    }


}
