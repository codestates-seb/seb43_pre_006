package com.codestates.PreProject.answer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AnswerResponseDto {
    private Long answerId;
    private Long questionId;
    private String displayName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String content;
}
