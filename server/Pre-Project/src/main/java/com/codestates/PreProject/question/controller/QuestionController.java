package com.codestates.PreProject.question.controller;

import com.codestates.PreProject.auth.interceptor.JwtParseInterceptor;
import com.codestates.PreProject.dto.MultiResponseDto;
import com.codestates.PreProject.dto.SingleResponseDto;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.repository.MemberRepository;
import com.codestates.PreProject.question.dto.CommentOfQuestionDto;
import com.codestates.PreProject.question.dto.QuestionDto;
import com.codestates.PreProject.question.entity.CommentOfQuestion;
import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.mapper.CommentOfQuestionMapper;
import com.codestates.PreProject.question.mapper.QuestionMapper;
import com.codestates.PreProject.question.service.CommentOfQuestionService;
import com.codestates.PreProject.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
@Validated
public class QuestionController {
    private final QuestionMapper mapper;

    private final CommentOfQuestionMapper commentMapper;
    private final QuestionService questionService;

    private final CommentOfQuestionService commentOfQuestionService;

    @PostMapping
    public ResponseEntity postQuestion(@Validated @RequestBody QuestionDto.Post requestBody) {

        Question question = questionService.createQuestion(mapper.questionPostDtoToQuestion(requestBody));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question)),HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                        @Validated @RequestBody QuestionDto.Patch requestBody) {

        requestBody.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.questionPatchDtoToQuestion(requestBody));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getQuestion(@PathVariable("id") @Positive long id) {

        Question question = questionService.findQuestion(id);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size,
                                       @RequestParam(value = "sortBy",required = false) String sortBy) {

        Page<Question> pageQuestions;
        List<Question> questions;

        // 정렬 로직 param로 받은 sortBy가 null이거나 like,view가 아닌 다른 값일 경우 최신순 정리
        if(sortBy != null){
            switch (sortBy) {
                case "like":
                    pageQuestions = questionService.findQuestionsByLike(page - 1, size);
                    questions = pageQuestions.getContent();
                    break;
                case "view":
                    pageQuestions = questionService.findQuestionsByView(page - 1, size);
                    questions = pageQuestions.getContent();
                    break;
                default:
                    pageQuestions = questionService.findQuestions(page - 1, size);
                    questions = pageQuestions.getContent();
                    break;
            }
        }else{
            pageQuestions = questionService.findQuestions(page - 1, size);
            questions = pageQuestions.getContent();
        }


//        List<Question> questions = pageQuestions.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.questionToQuestionResponseDtos(questions), pageQuestions), HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId) {

        questionService.deleteQuestion(questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{question-id}/vote")
    public ResponseEntity postVote(@PathVariable("question-id") @Positive long questionId) {
        Question question = questionService.createVote(questionId);

        return new ResponseEntity(new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question)),HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}/vote")
    public ResponseEntity deleteVote(@PathVariable("question-id") @Positive long questionId) {
        Question question = questionService.cancleVote(questionId);

        return new ResponseEntity(new SingleResponseDto<>(mapper.questionToQuestionResponseDto(question)),HttpStatus.OK);
    }

    @PostMapping("/{question-id}/comments")
    public ResponseEntity postComment(@PathVariable("question-id") @Positive long questionId ,
                                      @Validated @RequestBody CommentOfQuestionDto.Post requestBody) {
        CommentOfQuestion commentOfQuestion = commentMapper.commentPostToComment(requestBody);

        CommentOfQuestion comment = commentOfQuestionService.createComment(commentOfQuestion,questionId);

        return new ResponseEntity(new SingleResponseDto<>(commentMapper.commentToCommentResponse(comment)),HttpStatus.OK);
    }

    // 검색 기능
    @GetMapping("/search")
    public ResponseEntity searchTitle(@RequestParam(value ="title",required = false) String title,
                                      @RequestParam @Positive int page,
                                      @RequestParam @Positive int size){
        Page<Question> pageQuestions = questionService.searchByTitle(title, page, size);
        List<Question> questions = pageQuestions.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(mapper.questionToQuestionResponseDtos(questions),pageQuestions),HttpStatus.OK);
    }
}
