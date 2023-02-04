package com.example.freetalk.community.repository;

import com.example.freetalk.community.entity.Dislike;
import com.example.freetalk.community.entity.LikeJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DislikeJPARepository extends JpaRepository<Dislike, LikeJPAEntity> {

}
