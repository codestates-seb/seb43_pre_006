package com.codestates.PreProject.question.controller;

import com.codestates.PreProject.auth.interceptor.JwtParseInterceptor;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.repository.MemberRepository;
import com.codestates.PreProject.question.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final MemberRepository memberRepository;

    @PostMapping
    public ResponseEntity postQuestion(@RequestBody QuestionDto.Post requestBody){

        long authenticatedMemberId = JwtParseInterceptor.getAuthenticatedMemberId();

        log.info(String.valueOf(authenticatedMemberId));
        requestBody.setMemberId(authenticatedMemberId);

        Optional<Member> member = memberRepository.findById(authenticatedMemberId);
        Member findMember = member.orElseThrow();


        requestBody.setEmail(findMember.getEmail());

        return new ResponseEntity(requestBody, HttpStatus.OK);
    }
}
