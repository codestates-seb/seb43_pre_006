package com.codestates.PreProject.voteOfQuestion.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class LikeCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    private Long memberId;

    private Long questionId;

}
