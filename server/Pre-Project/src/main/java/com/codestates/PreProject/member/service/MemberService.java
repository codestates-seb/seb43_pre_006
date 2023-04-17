package com.codestates.PreProject.member.service;

import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member createMember(Member member) {

        return memberRepository.save(member);
    }
}
