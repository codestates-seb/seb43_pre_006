package com.codestates.PreProject.answer.mapper;

import com.codestates.PreProject.answer.dto.AnswerPostDto;
import com.codestates.PreProject.answer.dto.AnswerResponseDto;
import com.codestates.PreProject.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
}
