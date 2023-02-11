package com.example.freetalk.community.repository;

import com.example.freetalk.community.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingJPARepository extends JpaRepository<Posting, Long> {


}
