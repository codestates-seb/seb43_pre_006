package com.codestates.PreProject.question.controller;

import com.codestates.PreProject.dto.SingleResponseDto;
import com.codestates.PreProject.question.dto.CommentOfQuestionDto;
import com.codestates.PreProject.question.entity.CommentOfQuestion;
import com.codestates.PreProject.question.mapper.CommentOfQuestionMapper;
import com.codestates.PreProject.question.service.CommentOfQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/commentsOfQuestion")
@RequiredArgsConstructor
@Validated
public class CommentOfQuestionController {

    private final CommentOfQuestionService commentOfQuestionService;

    private final CommentOfQuestionMapper mapper;

    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@PathVariable("comment-id") @Positive long commentId,
                                       @Validated CommentOfQuestionDto.Patch requestBody){
        requestBody.setCommentId(commentId);
        CommentOfQuestion commentOfQuestion = commentOfQuestionService.updateComment(mapper.commentPatchToComment(requestBody));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponse(commentOfQuestion)), HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("comment-id") @Positive long commentId){
        commentOfQuestionService.deleteComment(commentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
