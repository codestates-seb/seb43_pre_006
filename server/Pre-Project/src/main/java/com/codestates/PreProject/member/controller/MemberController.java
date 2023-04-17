package com.codestates.PreProject.member.controller;

import com.codestates.PreProject.member.dto.MemberPostDto;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.mapper.MemberMapper;
import com.codestates.PreProject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/members")
@Validated
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;


    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        Member member = mapper.memberPostDtoToMember(memberPostDto);

        memberService.createMember(member);
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(member), HttpStatus.CREATED);
    }
}
