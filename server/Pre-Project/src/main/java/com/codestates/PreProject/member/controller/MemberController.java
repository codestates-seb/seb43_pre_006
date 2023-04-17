package com.codestates.PreProject.member.controller;

import com.codestates.PreProject.dto.SingleResponseDto;
import com.codestates.PreProject.member.dto.MemberDto;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.mapper.MemberMapper;
import com.codestates.PreProject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/members")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final MemberMapper mapper;

    @PostMapping("/signup")
    public ResponseEntity postMember(@RequestBody MemberDto.Post requestBody) {
        Member member = memberService.createMember(mapper.memberPostToMember(requestBody));

        return new ResponseEntity(new SingleResponseDto(mapper.memberToMemberResponse(member)), HttpStatus.CREATED);
    }

}
