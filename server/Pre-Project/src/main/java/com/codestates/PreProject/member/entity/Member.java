package com.codestates.PreProject.member.entity;

import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.entity.CommentOfAnswer;
import com.codestates.PreProject.audit.Auditable;
import com.codestates.PreProject.question.entity.CommentOfQuestion;
import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.entity.VoteOfQuestion;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String displayName;

    private String email;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<VoteOfQuestion> voteOfQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<CommentOfQuestion> commentOfQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<CommentOfAnswer> commentOfAnswers = new ArrayList<>();

    public void setCommentOfAnswer(CommentOfAnswer commentOfAnswer){
        commentOfAnswers.add(commentOfAnswer);
        if(commentOfAnswer.getMember() != this){
            commentOfAnswer.setMember(this);
        }
    }

    public void setAnswer(Answer answer) {
        answers.add(answer);
        if(answer.getMember() != this){
            answer.setMember(this);
        }
    }

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

    public void setCommentOfQuestion(CommentOfQuestion commentOfQuestion){
        commentOfQuestions.add(commentOfQuestion);
        if(commentOfQuestion.getMember() != this){
            commentOfQuestion.setMember(this);
        }
    }

    public Member(String email) {
        this.email = email;
    }
}
