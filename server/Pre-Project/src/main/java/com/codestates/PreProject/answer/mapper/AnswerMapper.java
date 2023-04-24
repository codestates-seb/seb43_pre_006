package com.codestates.PreProject.answer.mapper;

import com.codestates.PreProject.answer.dto.AnswerDto;
import com.codestates.PreProject.answer.entity.Answer;
import com.codestates.PreProject.question.dto.QuestionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    Answer answerPostDtoToAnswer(AnswerDto.AnswerPostDto requestBody);
    Answer answerPatchDtoToAnswer(AnswerDto.AnswerPatchDto requestBody);

    // 소스 a 엔티티의 변환할 객체, 타겟은 a rdto의 질문 아이디로 매핑한다
    @Mapping(source = "question.questionId", target = "questionId")
    @Mapping(source = "member.displayName",target = "displayName")
    @Mapping(source = "member.email",target = "email")
    AnswerDto.AnswerResponseDto answerToAnswerResponseDto(Answer answer);
    List<AnswerDto.AnswerResponseDto> answerListToAnswerResponseDto(List<Answer> answer);
    List<AnswerDto.AnswerResponseDto> answerToAnswerResponseDtos(List<Answer> answers);
}
