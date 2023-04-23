package com.codestates.PreProject.member.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberResponseDto {

    private String displayName;
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
