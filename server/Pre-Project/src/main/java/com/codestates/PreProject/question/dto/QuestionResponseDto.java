package com.codestates.PreProject.question.dto;

import com.codestates.PreProject.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QuestionResponseDto {
    private Long memberId;
    private Long questionId;
    private String title;
    private String content;
    private int likeCount;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

//    private Member member;

//    public Long getMember() {
//        return member.getMemberId();
//    }
}
