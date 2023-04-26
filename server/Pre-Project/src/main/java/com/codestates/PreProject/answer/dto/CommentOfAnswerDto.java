package com.codestates.PreProject.answer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class CommentOfAnswerDto {

    @Getter
    public static class Post{
        private String content;
    }

    @Getter
    public static class Patch{

        private long commentId;
        private String content;

        public void setCommentId(long commentId) {
            this.commentId = commentId;
        }
    }

    @Getter
    @Setter
    public static class Response{
        private long commentId;

        private long answerId;

        private String userName;

        private String userEmail;

        private String content;

        private LocalDateTime createdAt;

        private LocalDateTime modifiedAt;


    }
}
