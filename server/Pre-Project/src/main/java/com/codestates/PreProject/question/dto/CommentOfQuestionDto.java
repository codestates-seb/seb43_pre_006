package com.codestates.PreProject.question.dto;

import com.codestates.PreProject.question.entity.CommentOfQuestion;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class CommentOfQuestionDto {

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

        private long questionId;

        private String userName;

        private String userEmail;

        private String content;

        private LocalDateTime createdAt;

        private LocalDateTime modifiedAt;


    }
}
