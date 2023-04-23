package com.codestates.PreProject.question.repository;

import com.codestates.PreProject.question.entity.CommentOfQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentOfQuestionRepository extends JpaRepository<CommentOfQuestion,Long> {
}
