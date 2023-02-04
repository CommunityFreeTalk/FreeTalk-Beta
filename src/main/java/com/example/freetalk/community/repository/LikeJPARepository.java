package com.example.freetalk.community.repository;

import com.example.freetalk.community.entity.Like;
import com.example.freetalk.community.entity.LikeJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeJPARepository extends JpaRepository<Like, LikeJPAEntity> {

}
