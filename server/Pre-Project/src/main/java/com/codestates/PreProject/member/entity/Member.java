package com.codestates.PreProject.member.entity;


import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.audit.Auditable;
import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.entity.VoteOfQuestion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;


    @Column(nullable = false)
    private String displayName;

    private String email;

    private String password;


    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Answer> answers = new ArrayList<>();
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<VoteOfQuestion> voteOfQuestions = new ArrayList<>();

    public void setQuestion(Question question) { // 관계편의메서드 추가하기 쉽게 설계했고
        questions.add(question);
        if(question.getMember() != this)
            question.setMember(this);
    }

    public void setVoteOfQuestion(VoteOfQuestion voteOfQuestion){
        voteOfQuestions.add(voteOfQuestion);
        if(voteOfQuestion.getMember() != this){
            voteOfQuestion.setMember(this);
        }
    }

    public Member(String email) {
        this.email = email;
    }

}
