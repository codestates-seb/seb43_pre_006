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



}
