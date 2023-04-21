package com.codestates.PreProject.question.repository;

import com.codestates.PreProject.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    // 좋아요를 쿼리로 로직 짬
    // INSERT INTO vote_of_question (question_id, member_id) - vote_of_question 테이블에 question_id, member_id 삽입
    // SELECT :questionId, :memberId from dual - 삽입할 데이터를 선택
    // WHERE NOT EXISTS (SELECT question_id, member_id FROM vote_of_question WHERE question_id = :questionId and member_id = :memberId) - 테이블에 이미 삽입하려는 question_id와 member_id가 존재하지 않는 경우에만 데이터를 삽입합니다. 이미 존재한다면 무시
    // NOT EXISTS는 서브쿼리에 존재하는 결과가 있는지 없는지(조회결과 존재유무)만 판단하고, TRUE 또는 FALSE를 반환
    @Modifying
    @Query(value = "INSERT INTO vote_of_question (question_id, member_id) " +
            "SELECT :questionId, :memberId from dual " +
            "WHERE NOT EXISTS (SELECT question_id, member_id " +
                                "FROM vote_of_question " +
                                "WHERE question_id = :questionId and member_id = :memberId)", nativeQuery = true)
    int upVote(long questionId, long memberId);


    // 좋아요 테이블에 질문아이디랑 멤버아이디를 넣을거에요 근데 WHERE NOT EXISTS -> 테이블에 이미 삽입하려는 question_id와 member_id가 존재하지 않는 경우에만 데이터를 삽입


    // questionId와 memberId가 있는 row줄 삭제
    @Modifying
    @Query(value = "DELETE FROM vote_of_question WHERE question_id = :questionId and member_id = :memberId", nativeQuery = true)
    int downVote(long questionId, long memberId);

    // findBy~~ + 뒤에 Containing을 붙이면 Like와 같은 쿼리조회를함
    Page<Question> findByTitleContaining(String title, Pageable pageable);
}
