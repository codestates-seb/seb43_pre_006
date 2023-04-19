package com.codestates.PreProject.answer.service;

import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.repository.AnswerRepository;
import com.codestates.PreProject.exception.BusinessLogicException;
import com.codestates.PreProject.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AnswerService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public Answer createAnswer(Answer answer, long questionId) {

        Question question = findQuestionById(questionId);

        answer.setQuestion(question);

        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {

        Answer findAnswer = findAnswerById(answer.getAnswerId());

        Optional.ofNullable(answer.getContent())
                .ifPresent(findAnswer::setContent);

        return answerRepository.save(findAnswer);
    }

    public void deleteAnswer(long answerId) {
        answerRepository.deleteById(answerId);
    }


    public Answer findAnswer(long answerId) {
        return findAnswerById(answerId);
    }

    public Page<Answer> findAnswers(int page, int size) {
        return answerRepository.findAll(PageRequest.of(page, size,
                Sort.by("questionId").descending()));
    }



    public Answer findAnswerById(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer answer = optionalAnswer.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return answer;
    }

    public Question findQuestionById(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question question = optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        return question;
    }

}
