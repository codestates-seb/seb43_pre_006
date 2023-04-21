package com.codestates.PreProject.question.mapper;

import com.codestates.PreProject.question.dto.CommentOfQuestionDto;
import com.codestates.PreProject.question.entity.CommentOfQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentOfQuestionMapper {

    CommentOfQuestion commentPostToComment(CommentOfQuestionDto.Post requestBody);

    CommentOfQuestion commentPatchToComment(CommentOfQuestionDto.Patch requestBody);

    @Mapping(source = "question.questionId",target = "questionId")
    @Mapping(source = "member.displayName",target = "userName")
    @Mapping(source = "member.email", target = "userEmail")
    CommentOfQuestionDto.Response commentToCommentResponse(CommentOfQuestion commentOfQuestion);
}
