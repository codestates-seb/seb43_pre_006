package com.codestates.PreProject.answer.entity;

import com.codestates.PreProject.audit.Auditable;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Answer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private String content;

    private int likeCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @OneToMany(mappedBy = "answer")
    private List<CommentOfAnswer> commentOfAnswers = new ArrayList<>();


    public void setMember(Member member) {
        this.member = member;
        if(!this.member.getAnswers().contains(this)){
            this.member.getAnswers().add(this);
        }
    }

    public void setCommentOfAnswer(CommentOfAnswer commentOfAnswer){
        commentOfAnswers.add(commentOfAnswer);
        if(commentOfAnswer.getAnswer() != this){
            commentOfAnswer.setAnswer(this);
        }
    }
}