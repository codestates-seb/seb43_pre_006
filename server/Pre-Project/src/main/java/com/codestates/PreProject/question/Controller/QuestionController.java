package com.codestates.PreProject.question.Controller;

import com.codestates.PreProject.globaldto.MultiResponseDto;
import com.codestates.PreProject.question.dto.QuestionPatchDto;
import com.codestates.PreProject.question.dto.QuestionPostDto;
import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.mapper.QuestionMapper;
import com.codestates.PreProject.question.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Validated
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionMapper mapper;
    private final QuestionService service;

    @PostMapping
    public ResponseEntity postQuestion(@Validated @RequestBody QuestionPostDto questionPostDto) {

        Question question = mapper.questionPostDtoToQuestion(questionPostDto);

        service.createQuestion(question);

        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(question),HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("Question-id") @Positive long questionId,
                                        @Validated @RequestBody QuestionPatchDto questionPatchDto) {
        questionPatchDto.setQuestionId(questionId);

        Question question = mapper.questionPatchDtoToQuestion(questionPatchDto);
        service.updateQuestion(question);

        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(question), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getQuestion(@PathVariable("id") @Positive long id) {
        Question question = service.findQuestion(id);

        return new ResponseEntity<>(mapper.questionToQuestionResponseDto(question), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size) {
        Page<Question> pageQuestions = service.findQuestions(page - 1, size);
        List<Question> questions = pageQuestions.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.questionToQuestionResponseDtos(questions), pageQuestions), HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId) {

        service.deleteQuestion(questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
