package com.codestates.PreProject.answer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class AnswerDto {

    @Getter
    @Setter
    public static class AnswerPostDto {
        private Long answerId;

        private Long memberId;

        private Long questionId;

        private String content;
    }

    @Getter
    @Setter
    public static class AnswerPatchDto {

        private Long answerId;
        private String content;
        public Long getQuestionId() {
            return questionId;
        }

        private Long questionId;
    }

    @Getter
    @Setter
    public static class AnswerResponseDto {
        private Long answerId;

        public Long getQuestionId() {
            return questionId;
        }

        private Long questionId;
        private String displayName;
        private String email;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private String comments;

    }

}
