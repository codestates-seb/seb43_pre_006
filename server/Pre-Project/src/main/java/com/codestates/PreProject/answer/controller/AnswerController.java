package com.codestates.PreProject.answer.controller;

import com.codestates.PreProject.answer.dto.AnswerDto;
import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.mapper.AnswerMapper;
import com.codestates.PreProject.answer.service.AnswerService;
import com.codestates.PreProject.dto.SingleResponseDto;
import com.codestates.PreProject.globaldto.MultiResponseDto;
import com.codestates.PreProject.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;


@RequiredArgsConstructor // DI
@RestController
@Validated
@RequestMapping("/questions/{question-id}/answers")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper mapper;

    @PostMapping
    public ResponseEntity postAnswer(@PathVariable("question-id") @Positive long questionId,
                                     @Validated  @RequestBody AnswerDto.AnswerPostDto requestBody) {

        Answer answer = mapper.answerPostDtoToAnswer(requestBody);
        List<Answer> answerList = answerService.createAnswer(answer, questionId);
        return new ResponseEntity<>(mapper.answerListToAnswerResponseDto(answerList), HttpStatus.CREATED);
    }

//    @PatchMapping("/{answer-id}")
//    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
//                                      @Validated @RequestBody AnswerDto.AnswerPatchDto requestBody) {
//        requestBody.setAnswerId(answerId);
//
//        Answer answer = mapper.answerPatchDtoToAnswer(requestBody); // 수정하고자 하는 값
//        Answer answer1 = answerService.updateAnswer(answer); // 수정된 값
//
//        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(answer1), HttpStatus.CREATED);
//    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                      @PathVariable("question-id") @Positive long questionId,
                                      @Validated @RequestBody AnswerDto.AnswerPatchDto requestBody) {
        Answer answer = mapper.answerPatchDtoToAnswer(requestBody);
        answer.setAnswerId(answerId);//필요한가? -> 필요 -> patch에 answerId 정보 없음
        List<Answer> answerList = answerService.updateAnswer(answer, questionId);
        return new ResponseEntity(mapper.answerListToAnswerResponseDto(answerList), HttpStatus.OK);
    }

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") @Positive long id) {
        Answer answer = answerService.findAnswer(id);

        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(answer), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.answerToAnswerResponseDtos(answers), pageAnswers), HttpStatus.OK);

    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive long answerId) {
        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}