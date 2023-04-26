package com.codestates.PreProject.answer.mapper;

import com.codestates.PreProject.answer.dto.AnswerDto;
import com.codestates.PreProject.answer.dto.CommentOfAnswerDto;
import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.answer.entity.CommentOfAnswer;
import com.codestates.PreProject.question.dto.CommentOfQuestionDto;
import com.codestates.PreProject.question.dto.QuestionDto;
import com.codestates.PreProject.question.entity.CommentOfQuestion;
import com.codestates.PreProject.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    Answer answerPostDtoToAnswer(AnswerDto.Post requestBody);

    Answer answerPatchDtoToAnswer(AnswerDto.Patch requestBody);

    @Mapping(source = "question.questionId",target = "questionId")
    @Mapping(source = "member.displayName",target = "userName")
    @Mapping(source = "member.email",target = "userEmail")
    AnswerDto.Response answerToAnswerResponseDto(Answer answer);


    List<AnswerDto.Response> answerToAnswerResponseDtos(List<Answer> answers);

    @Mapping(source = "answer.answerId",target = "answerId")
    @Mapping(source = "member.displayName",target = "userName")
    @Mapping(source = "member.email", target = "userEmail")
    List<CommentOfAnswerDto.Response> commentToCommentResponse(List<CommentOfAnswer> commentOfAnswers);


}