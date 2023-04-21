package com.codestates.PreProject.member.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
public class MemberPostDto {
    @NotBlank
    private String displayName;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
