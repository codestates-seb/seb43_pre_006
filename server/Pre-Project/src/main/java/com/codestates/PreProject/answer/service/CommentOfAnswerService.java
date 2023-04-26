package com.codestates.PreProject.answer.service;

import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.entity.CommentOfAnswer;
import com.codestates.PreProject.answer.repository.AnswerRepository;
import com.codestates.PreProject.answer.repository.CommentOfAnswerRepository;
import com.codestates.PreProject.auth.interceptor.JwtParseInterceptor;
import com.codestates.PreProject.exception.BusinessLogicException;
import com.codestates.PreProject.exception.ExceptionCode;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.repository.MemberRepository;
import com.codestates.PreProject.question.entity.CommentOfQuestion;
import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.repository.CommentOfQuestionRepository;
import com.codestates.PreProject.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentOfAnswerService {

    private final AnswerRepository answerRepository;

    private final CommentOfAnswerRepository commentOfAnswerRepository;

    private final MemberRepository memberRepository;

    public CommentOfAnswer createComment(CommentOfAnswer commentOfAnswer, long answerId){
        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        Optional<Member> optionalMember = memberRepository.findById(authenticatedMemberId);

        Member member = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);

        Answer answer = optionalAnswer.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        commentOfAnswer.setMember(member);
        commentOfAnswer.setAnswer(answer);


        return commentOfAnswerRepository.save(commentOfAnswer);
    }

    public CommentOfAnswer updateComment(CommentOfAnswer commentOfAnswer){

        CommentOfAnswer findCommentOfAnswer = commentFindById(commentOfAnswer.getCommentId());

        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        memberAuthentication(findCommentOfAnswer,authenticatedMemberId);

        Optional.ofNullable(commentOfAnswer.getContent())
                .ifPresent(content -> findCommentOfAnswer.setContent(content));




        return commentOfAnswerRepository.save(findCommentOfAnswer);
    }


    public void deleteComment(long commentId) {
        CommentOfAnswer commentOfAnswer = commentFindById(commentId);

        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        memberAuthentication(commentOfAnswer,authenticatedMemberId);

        commentOfAnswerRepository.delete(commentOfAnswer);
    }

    public List<CommentOfAnswer> getComment(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer answer = optionalAnswer.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return commentOfAnswerRepository.findByAnswer(answer);
    }



    // 댓글작성자와 로그인멤버가 일치하는지 확인 로직
    private void memberAuthentication(CommentOfAnswer commentOfAnswer,long authenticatedMemberId) {
        if(commentOfAnswer.getMember().getMemberId() != authenticatedMemberId) throw new BusinessLogicException(ExceptionCode.MEMBER_AUTHENTICATION_ERROR);
    }

    private CommentOfAnswer commentFindById(long commentId) {
        Optional<CommentOfAnswer> optionalCommentOfAnswer = commentOfAnswerRepository.findById(commentId);
        CommentOfAnswer commentOfAnswer = optionalCommentOfAnswer.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        return commentOfAnswer;
    }
}
