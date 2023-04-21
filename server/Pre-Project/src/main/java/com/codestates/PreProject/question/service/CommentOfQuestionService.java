package com.codestates.PreProject.question.service;

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
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentOfQuestionService {
    private final QuestionRepository questionRepository;

    private final CommentOfQuestionRepository commentOfQuestionRepository;

    private final MemberRepository memberRepository;

    public CommentOfQuestion createComment(CommentOfQuestion commentOfQuestion,long questionId){
        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        Optional<Member> optionalMember = memberRepository.findById(authenticatedMemberId);

        Member member = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        Optional<Question> optionalQuestion = questionRepository.findById(questionId);

        Question question = optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        commentOfQuestion.setMember(member);
        commentOfQuestion.setQuestion(question);


        return commentOfQuestionRepository.save(commentOfQuestion);
    }

    public CommentOfQuestion updateComment(CommentOfQuestion commentOfQuestion){

        CommentOfQuestion findCommentOfQuestion = commentFindById(commentOfQuestion.getCommentId());

        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        memberAuthentication(findCommentOfQuestion,authenticatedMemberId);

        Optional.ofNullable(commentOfQuestion.getContent())
                .ifPresent(content -> findCommentOfQuestion.setContent(content));




        return commentOfQuestionRepository.save(findCommentOfQuestion);
    }


    public void deleteComment(long commentId) {
        CommentOfQuestion commentOfQuestion = commentFindById(commentId);

        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        memberAuthentication(commentOfQuestion,authenticatedMemberId);

        commentOfQuestionRepository.delete(commentOfQuestion);
    }

    // 댓글작성자와 로그인멤버가 일치하는지 확인 로직
    private void memberAuthentication(CommentOfQuestion commentOfQuestion,long authenticatedMemberId) {
        if(commentOfQuestion.getMember().getMemberId() != authenticatedMemberId) throw new BusinessLogicException(ExceptionCode.MEMBER_AUTHENTICATION_ERROR);
    }

    private CommentOfQuestion commentFindById(long commentId) {
        Optional<CommentOfQuestion> optionalCommentOfQuestion = commentOfQuestionRepository.findById(commentId);
        CommentOfQuestion commentOfQuestion = optionalCommentOfQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        return commentOfQuestion;
    }


}
