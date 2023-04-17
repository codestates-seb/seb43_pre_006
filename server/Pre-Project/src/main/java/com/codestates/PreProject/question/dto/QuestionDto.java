package com.codestates.PreProject.question.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class QuestionDto {
    @Getter
    public static class Post {
        private String title;
        @Setter
        private Long memberId;

        @Setter
        private String email;

    }

//    @Getter
//    @Setter
//    public static class Response {
//
//
//        private String title;
//
//    }
}
