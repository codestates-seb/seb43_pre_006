package com.codestates.PreProject.answer.controller;

import com.codestates.PreProject.answer.dto.AnswerDto;
import com.codestates.PreProject.answer.dto.CommentOfAnswerDto;
import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.entity.CommentOfAnswer;
import com.codestates.PreProject.answer.mapper.AnswerMapper;
import com.codestates.PreProject.answer.mapper.CommentOfAnswerMapper;
import com.codestates.PreProject.answer.service.AnswerService;
import com.codestates.PreProject.answer.service.CommentOfAnswerService;
import com.codestates.PreProject.dto.MultiResponseDto;
import com.codestates.PreProject.dto.SingleResponseDto;
import com.codestates.PreProject.question.service.CommentOfQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;


@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/questions/{question-id}/answers")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper mapper;

    private final CommentOfAnswerMapper commentMapper;

    private final CommentOfAnswerService commentService;
    @PostMapping
    public ResponseEntity postAnswer(@PathVariable("question-id") @Positive long questionId,
                                     @Validated  @RequestBody AnswerDto.Post requestBody) {
        Answer answer = answerService.createAnswer(mapper.answerPostDtoToAnswer(requestBody), questionId);
        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(answer), HttpStatus.CREATED);
    }


    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                      @PathVariable("question-id") @Positive long questionId,
                                      @Validated @RequestBody AnswerDto.Patch requestBody) {
        requestBody.setAnswerId(answerId);
        Answer answer = answerService.updateAnswer(mapper.answerPatchDtoToAnswer(requestBody), questionId);
        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(answer), HttpStatus.OK);
    }

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") @Positive long id) {
        Answer answer = answerService.findAnswer(id);

        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(answer), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(
                                    @Positive @RequestParam int page,
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

    @PostMapping("/{answer-id}/comments")
    public ResponseEntity postComment(@PathVariable("answer-id") @Positive long answerId,
                                      @RequestBody CommentOfAnswerDto.Post requestBody) {

        CommentOfAnswer comment = commentService.createComment(commentMapper.commentPostToComment(requestBody), answerId);

        return new ResponseEntity<>(new SingleResponseDto<>(commentMapper.commentToCommentResponse(comment)),HttpStatus.CREATED);

    }

    @GetMapping("/{answer-id}/comments")
    public ResponseEntity getComment(
            @PathVariable("answer-id") @Positive long answerId) {
        List<CommentOfAnswer> comment = commentService.getComment(answerId);

        return new ResponseEntity<>(new SingleResponseDto<>(commentMapper.commentToCommentResponse(comment)),HttpStatus.OK);
    }

}