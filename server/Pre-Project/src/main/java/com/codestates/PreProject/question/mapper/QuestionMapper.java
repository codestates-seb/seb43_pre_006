package com.codestates.PreProject.question.mapper;

import com.codestates.PreProject.question.dto.QuestionDto;
import com.codestates.PreProject.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    Question questionPostDtoToQuestion(QuestionDto.Post requestBody);

    Question questionPatchDtoToQuestion(QuestionDto.Patch requestBody);

    // 소스 Q 엔티티의 변환할 객체, 타겟은 q rdto의 멤버 아이디로 매핑한다
    QuestionDto.Response questionToQuestionResponseDto(Question question);

    List<QuestionDto.Response> questionToQuestionResponseDtos(List<Question> questions);
}
