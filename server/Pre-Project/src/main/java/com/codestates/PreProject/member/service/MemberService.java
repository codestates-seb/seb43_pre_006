package com.codestates.PreProject.member.service;

import com.codestates.PreProject.auth.utils.CustomAuthorityUtils;
import com.codestates.PreProject.exception.BusinessLogicException;
import com.codestates.PreProject.exception.ExceptionCode;
import com.codestates.PreProject.helper.event.MemberRegistrationApplicationEvent;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CustomAuthorityUtils authorityUtils;
    private final PasswordEncoder passwordEncoder;

    private final ApplicationEventPublisher publisher;

    public Member createMember(Member member){
        verifyExistsEmail(member.getEmail());

        if(member.getPassword() != null){ // oauth2 로그인은 비밀번호가 없기 때문에 로직을 검
            String encryptedPassword = passwordEncoder.encode(member.getPassword());
            member.setPassword(encryptedPassword);
        }

        if(member.getDisplayName() == null) member.setDisplayName(member.getEmail()); // oauth2는 닉네임을 이메일로 설정

        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        Member savedMember = memberRepository.save(member);

        publisher.publishEvent(new MemberRegistrationApplicationEvent(this,savedMember));
        return savedMember;

    }

    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);

        memberRepository.delete(findMember);
    }

    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member member = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return member;
    }

    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);

        if(member.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
