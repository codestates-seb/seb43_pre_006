package com.codestates.PreProject.answer.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class AnswerPostDto {
    private Long memberId;
    private String content;
}
