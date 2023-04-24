package com.codestates.PreProject.exception;

import lombok.Getter;

public enum ExceptionCode {

    MEMBER_NOT_FOUND(404, "Member not found"),

    ANSWER_NOT_FOUND(404,"Answer Not Found"),

    MEMBER_EXISTS(409, "Member exists"),

    QUESTION_NOT_FOUND(404, "Member not found"),

    QUESTION_EXISTS(409, "Member exists"),

    NO_PERMISSION_POST(404, "Member not found"),

    VOTE_NOT_TWICE(409,"Vote Not twice"),

    VOTE_NOT_CANCEL(204,"Vote Not cancel"),
    MEMBER_AUTHENTICATION_ERROR(401,"Member don't match"),

    COMMENT_NOT_FOUND(404, "Comment not found");


    @Getter
    private int status;

    @Getter
    private String message;


    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}

