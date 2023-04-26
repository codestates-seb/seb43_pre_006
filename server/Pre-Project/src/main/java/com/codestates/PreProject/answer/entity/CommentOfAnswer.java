package com.codestates.PreProject.answer.entity;

import com.codestates.PreProject.audit.Auditable;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class CommentOfAnswer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String content;

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    public void setAnswer(Answer answer) {
        this.answer = answer;
        if(!answer.getCommentOfAnswers().contains(this)){
            answer.getCommentOfAnswers().add(this);
        }
    }

    public void setMember(Member member) {
        this.member = member;
        if(!member.getCommentOfAnswers().contains(this)){
            member.getCommentOfAnswers().add(this);
        }
    }
}
