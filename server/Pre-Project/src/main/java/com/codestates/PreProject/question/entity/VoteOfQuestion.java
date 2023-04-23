package com.codestates.PreProject.question.entity;

import com.codestates.PreProject.audit.Auditable;
import com.codestates.PreProject.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class VoteOfQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public void setMember(Member member){ // 관계편의메서드
        this.member = member;
        if(!this.member.getVoteOfQuestions().contains(this)) {
            this.member.getVoteOfQuestions().add(this);
        }
    }

    public void setQuestion(Question question){
        this.question = question;
        if (!this.question.getVoteOfQuestions().contains(this)) {
            this.question.getVoteOfQuestions().add(this);
        }
    }
}
