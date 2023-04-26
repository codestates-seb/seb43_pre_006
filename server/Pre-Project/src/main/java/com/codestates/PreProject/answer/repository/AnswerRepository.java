package com.codestates.PreProject.answer.repository;

import com.codestates.PreProject.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
