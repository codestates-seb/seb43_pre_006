package com.codestates.PreProject.question.repository;

import com.codestates.PreProject.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
