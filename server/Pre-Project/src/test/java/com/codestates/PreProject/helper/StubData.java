package com.codestates.PreProject.helper;

import com.codestates.PreProject.auth.jwt.JwtTokenizer;
import com.codestates.PreProject.member.dto.MemberDto;
import com.codestates.PreProject.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.time.LocalDateTime;
import java.util.*;

public class StubData {
    public static class MockSecurity {
        public static String getInvalidAccessToken() {
            return "eyJhbGciOiJIUzUxMiJ9.NjA2NDUwOTc3LCJtZW1iZXJJZCI6Mjd9.1TvYDexLUkOkOsBksbS6dnyJ4Ig1m9LMdTJ2FzCdOW0GEEdM4S6MpLZTpMGZCa-BN9jnbC9htZljsi5e7Mc-OQ";
        }

        /**
         * 실제 사용할 수 있는 유효한 JWT를 생성한다.
         *
         * @param secretKey JwtVerificationFilter에서 사용되는 key와 일치해야 한다.
         * @param role 원하는 role로 지정 가능 (USER, ADMIN)
         * @return
         */
        public static String getValidAccessToken(String secretKey, String role) {
            JwtTokenizer jwtTokenizer = new JwtTokenizer();
            Map<String, Object> claims = new HashMap<>();
            claims.put("memberId", 1L);
            claims.put("roles", List.of(role));

            String subject = "test access token";
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, 1);
            Date expiration = calendar.getTime();

            String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(secretKey);

            String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

            return accessToken;
        }
    }
    public static class MockMember {
        private static Map<HttpMethod, Object> stubRequestBody;
        static {
            stubRequestBody = new HashMap<>();
            stubRequestBody.put(HttpMethod.POST, new MemberDto.Post("하이","test@naver.com", "홍길동"));
        }

        public static Object getRequestBody(HttpMethod method) {
            return stubRequestBody.get(method);
        }

        public static MemberDto.Response getSingleResponseBody() {
            return new MemberDto.Response(1L,
                    "하이",
                    "test@naver.com",
                    "홍길동",
                    LocalDateTime.now(),
                    LocalDateTime.now());
        }

        public static List<MemberDto.Response> getMultiResponseBody() {
            return List.of(
                    new MemberDto.Response(1L,
                            "하이",
                            "test@naver.com",
                            "홍길동",
                            LocalDateTime.now(),
                            LocalDateTime.now()),
                    new MemberDto.Response(2L,
                            "안녕",
                            "test2@naver.com",
                            "홍길순",
                            LocalDateTime.now(),
                            LocalDateTime.now())
            );
        }

//        public static Member getSingleResultMember() {
//            Member member = new Member("하이", "test@naver.com", "홍길동",);
//
//            return member;
//        }
//
//        public static Page<Member> getMultiResultMember() {
//            Member member1 = new Member("hgd1@gmail.com", "홍길동1", "010-1111-1111");
//            member1.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
//            member1.setStamp(new Stamp());
//
//            Member member2 = new Member("hgd2@gmail.com", "홍길동2", "010-2222-2222");
//            member2.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
//            member2.setStamp(new Stamp());
//
//            return new PageImpl<>(List.of(member1, member2),
//                    PageRequest.of(0, 10, Sort.by("memberId").descending()),
//                    2);
//        }
//
//        public static Member getSingleResultMember(long memberId) {
//            Member member = new Member("hgd@gmail.com", "홍길동", "010-1111-1111");
//            member.setMemberId(memberId);
//            member.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
//            member.setStamp(new Stamp());
//            return member;
//        }
//
//        public static Member getSingleResultMember(long memberId, Map<String, String> updatedInfo) {
//            String name = Optional.ofNullable(updatedInfo.get("name")).orElse("홍길동");
//            String phone = Optional.ofNullable(updatedInfo.get("phone")).orElse("010-1111-1111");
//            Member member = new Member("hgd@gmail.com", name, phone);
//            member.setMemberId(memberId);
//            member.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
//            member.setStamp(new Stamp());
//            return member;
//        }
    }

}
