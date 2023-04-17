package com.codestates.PreProject.member.repository;

import com.codestates.PreProject.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
