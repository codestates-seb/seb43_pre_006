package com.codestates.PreProject.answer.controller;

import com.codestates.PreProject.answer.dto.CommentOfAnswerDto;
import com.codestates.PreProject.answer.entity.CommentOfAnswer;
import com.codestates.PreProject.answer.mapper.CommentOfAnswerMapper;
import com.codestates.PreProject.answer.service.CommentOfAnswerService;
import com.codestates.PreProject.dto.SingleResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
@RestController
@RequestMapping("/commentsOfAnswer")
@RequiredArgsConstructor
@Validated
public class CommentOfAnswerController {
    private final CommentOfAnswerService commentOfAnswerService;

    private final CommentOfAnswerMapper mapper;

    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@PathVariable("comment-id") @Positive long commentId,
                                       @Validated CommentOfAnswerDto.Patch requestBody){
        requestBody.setCommentId(commentId);
        CommentOfAnswer commentOfAnswer = commentOfAnswerService.updateComment(mapper.commentPatchToComment(requestBody));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponse(commentOfAnswer)), HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("comment-id") @Positive long commentId){
        commentOfAnswerService.deleteComment(commentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
