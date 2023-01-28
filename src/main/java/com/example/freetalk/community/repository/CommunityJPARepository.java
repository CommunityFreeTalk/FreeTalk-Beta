package com.example.freetalk.community.repository;

import com.example.freetalk.community.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityJPARepository extends JpaRepository<Community, Long> {

    boolean existsByCommunityName(String communityName);
}
