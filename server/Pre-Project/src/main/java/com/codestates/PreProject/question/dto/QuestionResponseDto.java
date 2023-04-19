package com.codestates.PreProject.question.dto;

import com.codestates.PreProject.answer.dto.AnswerDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

    private List<AnswerDto.AnswerResponseDto> answers; // 추가

//    private Member member;

//    public Long getMember() {
//        return member.getMemberId();
//    }
}
