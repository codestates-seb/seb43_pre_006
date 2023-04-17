package com.codestates.PreProject.answer.service;

import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.repository.AnswerRepository;
import com.codestates.PreProject.exception.BusinessLogicException;
import com.codestates.PreProject.exception.ExceptionCode;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {
        verifyAnswer(answer.getMember().getMemberId());

        Optional.ofNullable(answer.getContent())

    }

    public void verifyAnswer(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        optionalAnswer.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
    }


}
