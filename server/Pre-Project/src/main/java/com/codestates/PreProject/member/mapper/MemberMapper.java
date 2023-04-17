package com.codestates.PreProject.member.mapper;

import com.codestates.PreProject.member.dto.MemberPostDto;
import com.codestates.PreProject.member.dto.MemberResponseDto;
import com.codestates.PreProject.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
