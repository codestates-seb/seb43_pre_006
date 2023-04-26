package com.codestates.PreProject.answer.mapper;

import com.codestates.PreProject.answer.dto.CommentOfAnswerDto;
import com.codestates.PreProject.answer.entity.CommentOfAnswer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentOfAnswerMapper {
    CommentOfAnswer commentPostToComment(CommentOfAnswerDto.Post requestBody);

    CommentOfAnswer commentPatchToComment(CommentOfAnswerDto.Patch requestBody);

    @Mapping(source = "answer.answerId",target = "answerId")
    @Mapping(source = "member.displayName",target = "userName")
    @Mapping(source = "member.email", target = "userEmail")
    CommentOfAnswerDto.Response commentToCommentResponse(CommentOfAnswer commentOfAnswer);

    @Mapping(source = "answer.answerId",target = "answerId")
    @Mapping(source = "member.displayName",target = "userName")
    @Mapping(source = "member.email", target = "userEmail")
    List<CommentOfAnswerDto.Response> commentToCommentResponse(List<CommentOfAnswer> commentOfAnswers);
}
