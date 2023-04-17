package com.codestates.PreProject.answer.controller;

import com.codestates.PreProject.answer.dto.AnswerPostDto;
import com.codestates.PreProject.answer.dto.AnswerResponseDto;
import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.mapper.AnswerMapper;
import com.codestates.PreProject.answer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor // DI
@RestController
@Validated
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper mapper;

    @PostMapping
    public ResponseEntity postAnswer(@Validated @RequestBody AnswerPostDto answerPostDto) {
        Answer answer = mapper.answerPostDtoToAnswer(answerPostDto);

        answerService.createAnswer(answer);

        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(answer), HttpStatus.CREATED);

    }
}
