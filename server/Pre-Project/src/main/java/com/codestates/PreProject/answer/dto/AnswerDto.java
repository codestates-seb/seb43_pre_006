package com.codestates.PreProject.answer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class AnswerDto {

    @Getter
    @Setter
    public static class Post {
        private String content;
    }

    @Getter
    @Setter
    public static class Patch {

        private Long answerId;
        private String content;
        private Long questionId;
    }

    @Getter
    @Setter
    public static class Response {
        private Long answerId;
        private Long questionId;
        private String userName;
        private String userEmail;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private List<CommentOfAnswerDto.Response> commentOfAnswers;

    }

}