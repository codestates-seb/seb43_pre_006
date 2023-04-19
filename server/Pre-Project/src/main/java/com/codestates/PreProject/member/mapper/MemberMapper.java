package com.codestates.PreProject.member.mapper;

import com.codestates.PreProject.member.dto.MemberDto;
import com.codestates.PreProject.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    Member memberPostToMember(MemberDto.Post requestBody);

    MemberDto.Response memberToMemberResponse(Member member);
}
