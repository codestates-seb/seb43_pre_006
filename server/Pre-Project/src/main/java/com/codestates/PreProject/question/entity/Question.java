package com.codestates.PreProject.question.entity;


import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.audit.Auditable;
import com.codestates.PreProject.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private Long questionId;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private int likeCount;

    private int viewCount = 0;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // 같이 삭제되게
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<VoteOfQuestion> voteOfQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<CommentOfQuestion> commentOfQuestions = new ArrayList<>();

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

    public void setCommentOfQuestion(CommentOfQuestion commentOfQuestion){
        commentOfQuestions.add(commentOfQuestion);
        if(commentOfQuestion.getQuestion() != this){
            commentOfQuestion.setQuestion(this);
        }
    }


}
