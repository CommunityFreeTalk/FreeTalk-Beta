package com.example.freetalk.community.repository;


import com.example.freetalk.community.entity.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagJPARepository  extends JpaRepository<HashTag, Long> {

    HashTag findByName(String name);

}
