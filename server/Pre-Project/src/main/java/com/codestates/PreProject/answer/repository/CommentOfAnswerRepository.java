package com.codestates.PreProject.answer.repository;

import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.entity.CommentOfAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentOfAnswerRepository extends JpaRepository<CommentOfAnswer,Long> {

    List<CommentOfAnswer> findByAnswer(Answer answer);
}
