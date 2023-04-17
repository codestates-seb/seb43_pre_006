package com.codestates.PreProject.question.service;

import com.codestates.PreProject.exception.BusinessLogicException;
import com.codestates.PreProject.exception.ExceptionCode;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.repository.MemberRepository;
import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;

    public Question createQuestion(Question question) {

        verifyMember(question.getMember().getMemberId());

        return questionRepository.save(question);

    }

    public Question updateQuestion(Question question) {

        verifyMember(question.getMember().getMemberId());

        Question findQuestion = findVerifiedQuestion(question.getQuestionId());

        Optional.ofNullable(question.getTitle())
                .ifPresent(findQuestion::setTitle);
        Optional.ofNullable(question.getContent())
                .ifPresent(findQuestion::setContent);

        return questionRepository.save(findQuestion);
    }

    public void deleteQuestion(long questionId) {

        Question findQuestion = findVerifiedQuestion(questionId);

        questionRepository.delete(findQuestion);
    }




    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion =
                questionRepository.findById(questionId);
        Question findQuestion =
                optionalQuestion.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return findQuestion;
    }

    public void verifyMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }



    public Question findQuestion(long id) {

        Optional<Question> findQuestion = questionRepository.findById(id);
        Question question = findQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        question.setViewCount(question.getViewCount() + 1);
        questionRepository.save(question);

        return findVerifiedQuestion(id);
    }

    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("questionId").descending()));
    }






}
