package com.codestates.PreProject.answer.service;

import com.codestates.PreProject.answer.entity.CommentOfAnswer;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.repository.MemberRepository;
import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.repository.QuestionRepository;
import com.codestates.PreProject.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.repository.AnswerRepository;
import com.codestates.PreProject.exception.BusinessLogicException;
import com.codestates.PreProject.exception.ExceptionCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    private final AnswerRepository answerRepository;
    private final MemberRepository memberRepository;

    public Answer createAnswer(Answer answer, Long questionId) {
        Question question = questionService.findVerifiedQuestion(questionId);
        //Spring Security의 SecurityContextHolder에서 인증된 사용자 정보를 가져와 memberRepository를 사용하여 해당 사용자를 찾음.
        String principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Optional<Member> optionalUser = memberRepository.findByEmail(principal);
        Member member = optionalUser.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        //답변 객체에 사용자와 질문을 설정하고 answerRepository를 사용하여 저장
        answer.setMember(member);
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer, Long questionId) {
        Question question = questionService.findVerifiedQuestion(questionId); // question 찾고
        Answer findAnswer = findAnswerById(answer.getAnswerId());// answer 찾고
        //Spring Security의 SecurityContextHolder에서 해당 Answer 객체의 작성자와 현재 로그인한 사용자가 같은지를 확인하고
        String principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

        if (!findAnswer.getMember().getEmail().equals(principal))
            throw new BusinessLogicException(ExceptionCode.MEMBER_AUTHENTICATION_ERROR);
        //Question 객체에 해당 Answer 객체가 포함되어 있는지도 확인.
        if (!question.getAnswers().contains(findAnswer))
            throw new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND);

        findAnswer.setContent(answer.getContent());
        return answerRepository.save(findAnswer);

//        Answer findAnswer = findAnswerById(answer.getAnswerId());
//
//        Optional.ofNullable(answer.getContent())
//                .ifPresent(findAnswer::setContent);
//
//        return answerRepository.save(findAnswer);
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
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId); //optionalAnswer를 레포에서 answerId로 조회
        Answer answer = optionalAnswer.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return answer;
    }

    public Question findQuestionById(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question question = optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        return question;
    }


}