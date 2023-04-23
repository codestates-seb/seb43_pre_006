package com.codestates.PreProject.question.mapper;

import com.codestates.PreProject.question.dto.CommentOfQuestionDto;
import com.codestates.PreProject.question.dto.QuestionDto;
import com.codestates.PreProject.question.entity.CommentOfQuestion;
import com.codestates.PreProject.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {


    Question questionPostDtoToQuestion(QuestionDto.Post requestBody);

    Question questionPatchDtoToQuestion(QuestionDto.Patch requestBody);

    @Mapping(source = "member.displayName",target = "userName")
    @Mapping(source = "member.email",target = "userEmail")
    QuestionDto.Response questionToQuestionResponseDto(Question question);

    List<QuestionDto.Response> questionToQuestionResponseDtos(List<Question> questions);


    @Mapping(source = "question.questionId",target = "questionId")
    @Mapping(source = "member.displayName",target = "userName")
    @Mapping(source = "member.email", target = "userEmail")
    CommentOfQuestionDto.Response commentToCommentResponse(CommentOfQuestion commentOfQuestion);
}
