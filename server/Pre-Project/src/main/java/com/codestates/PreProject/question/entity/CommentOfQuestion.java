package com.codestates.PreProject.question.entity;

import com.codestates.PreProject.audit.Auditable;
import com.codestates.PreProject.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class CommentOfQuestion extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String content;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    public void setQuestion(Question question) {
        this.question = question;
        if(!question.getCommentOfQuestions().contains(this)){
            question.getCommentOfQuestions().add(this);
        }
    }

    public void setMember(Member member) {
        this.member = member;
        if(!member.getCommentOfQuestions().contains(this)){
            member.getCommentOfQuestions().add(this);
        }
    }
}
