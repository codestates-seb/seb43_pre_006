package com.codestates.PreProject.question.service;

import com.codestates.PreProject.auth.interceptor.JwtParseInterceptor;
import com.codestates.PreProject.exception.BusinessLogicException;
import com.codestates.PreProject.exception.ExceptionCode;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.repository.MemberRepository;
import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.entity.VoteOfQuestion;
import com.codestates.PreProject.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;

    public Question createQuestion(Question question) {

        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        verifiyQuestion(question,authenticatedMemberId);


        return questionRepository.save(question);

    }



    public Question updateQuestion(Question question) {

        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId(); // 로그인 된 사용자 아이디 불러오기

        Question findQuestion = findVerifiedQuestion(question.getQuestionId());

        memberAuthentication(findQuestion,authenticatedMemberId);

        Optional.ofNullable(question.getTitle())
                .ifPresent(findQuestion::setTitle);
        Optional.ofNullable(question.getContent())
                .ifPresent(findQuestion::setContent);

        return questionRepository.save(findQuestion);
    }

    public void deleteQuestion(long questionId) {

        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        Question findQuestion = findVerifiedQuestion(questionId);

        memberAuthentication(findQuestion,authenticatedMemberId);

        questionRepository.delete(findQuestion);
    }


    public Question findQuestion(long id) {

        Question question = findVerifiedQuestion(id);

        question.setViewCount(question.getViewCount() + 1);

        return findVerifiedQuestion(id);
    }

    // questionId순 정렬
    @Transactional(readOnly = true)
    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("questionId").descending()));
    }

    // 조회수순 정렬
    @Transactional(readOnly = true)
    public Page<Question> findQuestionsByView(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("viewCount").descending()));
    }

    // 좋아요순 정렬
    @Transactional(readOnly = true)
    public Page<Question> findQuestionsByLike(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("likeCount").descending()));
    }

    // 검색 기능
    public Page<Question> searchByTitle(String title,int page, int size){
        if(title == null) title = "";

//        List<Question> listQuestion = questionRepository.findByTitleContaining(title);
//
//        Page<Question> searchQuestions = listQuestionByPage(listQuestion,page,size);
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by("questionId").descending());
        Page<Question> byTitleContaining = questionRepository.findByTitleContaining(title, pageRequest);
        return byTitleContaining;
//        return searchQuestions;
    }


//    // List를 Page로 만들어주는 메서드 ( 검색 기능에 활용 )
//    public Page<Question> listQuestionByPage(List<Question> questions, int pageNo, int pageSize){
//        int startIndex = (pageNo - 1) * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, questions.size());
//
//        List<Question> sublist = questions.subList(startIndex, endIndex);
//        PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize, Sort.by("questionId").descending());
//        return new PageImpl<>(sublist, pageRequest, questions.size());
//
//    }


    // 좋아요 로직
    public Question createVote(long questionId){
        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        Question question = findVerifiedQuestion(questionId);

        // 멤버 아이디로 멤버 찾기
        Optional<Member> optionalMember = memberRepository.findById(authenticatedMemberId);
        Member member = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        // 멤버가 좋아요한 게시글의 아이디를 가져와서 이 게시글의 아이디랑 비교를 해요
        // 비교를 했는데 존재한다?  -> 좋아요가 된 게시물

        for (VoteOfQuestion voteOfQuestion : member.getVoteOfQuestions()) { // 좋아요 두번 불가
            if (voteOfQuestion.getQuestion().getQuestionId() == question.getQuestionId()) {
                throw new BusinessLogicException(ExceptionCode.VOTE_NOT_TWICE);
            }
        }


        questionRepository.upVote(question.getQuestionId(), authenticatedMemberId);

        question.setLikeCount(question.getLikeCount() + 1);

        return question;
    }

    public Question cancleVote(long questionId){
        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        Question question = findVerifiedQuestion(questionId);
        Optional<Member> optionalMember = memberRepository.findById(authenticatedMemberId);
        Member member = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));


        // stream을 활용해서 질문의 좋아요목록을 가져와요 이 좋아요 목록의 멤버들을 하나하나씩 조회 -> 로그인된 멤버가 없다면 비지니스로직에러

        question.getVoteOfQuestions().stream() // 좋아요 한 사람만 취소 가능
                        .filter(q -> q.getMember() == member)
                                .findFirst()
                                        .orElseThrow(() -> new BusinessLogicException(ExceptionCode.VOTE_NOT_CANCEL));


        questionRepository.downVote(question.getQuestionId(), authenticatedMemberId);

        question.setLikeCount(question.getLikeCount() - 1);

        return question;
    }


    // 질문 등록할때 멤버가 존재하는지 여부 확인 및 세팅
    private void verifiyQuestion(Question question,long authenticatedMemberId) {
        Optional<Member> findMember = memberRepository.findById(authenticatedMemberId);
        Member member = findMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        question.setMember(member);
//        question.setUserName(member.getDisplayName());
//        question.setUserEmail(member.getEmail());
    }

    // 질문아이디로 질문이 존재하는지 확인
    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion =
                questionRepository.findById(questionId);
        Question findQuestion =
                optionalQuestion.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return findQuestion;
    }


    // 게시글과 로그인된 사용자가 일치하는지 판단하는 로직 일치하지 않다면 인증 에러를 보냄
    private void memberAuthentication(Question question,long authenticatedMemberId) {
        if(question.getMember().getMemberId() != authenticatedMemberId) throw new BusinessLogicException(ExceptionCode.MEMBER_AUTHENTICATION_ERROR);
    }
}
