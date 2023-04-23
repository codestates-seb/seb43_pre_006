package com.codestates.PreProject.question.dto;

import com.codestates.PreProject.question.entity.CommentOfQuestion;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {
    @Getter
    public static class Post {
        private String title;

        private String content;

        @Setter
        private String email;

    }

    @Getter
    public static class Patch {

        @Setter
        private Long questionId;

        private String title;

        private String content;

    }
    @Getter
    @Setter
    public static class Response {

        private Long questionId;

        private String title;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private Integer likeCount;
        private Integer viewCount;
        private String userName;
        private String userEmail;

        List<CommentOfQuestionDto.Response> commentOfQuestions;

    }
}
