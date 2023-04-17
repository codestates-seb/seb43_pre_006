package com.codestates.PreProject.voteOfQuestion.repository;

import com.codestates.PreProject.voteOfQuestion.entity.LikeCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeCountRepository extends JpaRepository<LikeCount, Long> {
}
