package com.codestates.PreProject.question.entity;

import com.codestates.PreProject.audit.Auditable;
import com.codestates.PreProject.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Question extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long QuestionId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private int likeCount;

    private int viewCount = 0;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private Long userId;

    private String userName;

    private String userEmail;

    @OneToMany(mappedBy = "question")
    private List<VoteOfQuestion> voteOfQuestions = new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;
        if (!this.member.getQuestions().contains(this)) {
            this.member.getQuestions().add(this);
        }
    }

    public void setVoteOfQuestions(VoteOfQuestion voteOfQuestions) {
        this.voteOfQuestions.add(voteOfQuestions);
        if (voteOfQuestions.getQuestion() != this){
            voteOfQuestions.setQuestion(this);
        }
    }
}
