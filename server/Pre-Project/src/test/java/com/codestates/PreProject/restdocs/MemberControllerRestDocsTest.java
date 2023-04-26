package com.codestates.PreProject.restdocs;

import com.codestates.PreProject.auth.jwt.JwtTokenizer;
import com.codestates.PreProject.auth.utils.CustomAuthorityUtils;
import com.codestates.PreProject.config.SecurityConfiguration;
import com.codestates.PreProject.helper.StubData;
import com.codestates.PreProject.member.controller.MemberController;
import com.codestates.PreProject.member.dto.MemberDto;
import com.codestates.PreProject.member.entity.Member;
import com.codestates.PreProject.member.mapper.MemberMapper;
import com.codestates.PreProject.member.service.MemberService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static com.codestates.PreProject.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.codestates.PreProject.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import({SecurityConfiguration.class, JwtTokenizer.class, CustomAuthorityUtils.class})
@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MemberControllerRestDocsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberMapper mapper;

    @Autowired
    private Gson gson;

    @Autowired
    private JwtTokenizer jwtTokenizer;
    private String accessTokenForUser;
    private String accessTokenForAdmin;

    @BeforeAll
    public void init() {
        System.out.println("# BeforeAll");
        accessTokenForUser = StubData.MockSecurity.getValidAccessToken(jwtTokenizer.getSecretKey(), "USER");
        accessTokenForAdmin = StubData.MockSecurity.getValidAccessToken(jwtTokenizer.getSecretKey(), "ADMIN");
    }

    @Test
    public void postMemberTest() throws Exception{
        MemberDto.Post post = new MemberDto.Post("진영","ku3026@gmail.com","jyjy");
        String content = gson.toJson(post);

        given(mapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());

        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());

        MemberDto.Response mockResultMember = new MemberDto.Response();
        mockResultMember.setMemberId(1L);

        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(mockResultMember);

        ResultActions actions = mockMvc.perform(
                post("/members/signup")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        actions.andExpect(status().isCreated())
                .andDo(document("post-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("displayName").type(JsonFieldType.STRING).description("닉네임"),
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호")
                                )
                        )
                        ));
    }

    @Test
    public void deleteMemberTest() throws Exception {
        long memberId = 1L;

        doNothing().when(memberService).deleteMember(Mockito.anyLong());

        mockMvc.perform(
                delete("/members/{member-id}", memberId)
                        .header("Authorization", "Bearer ".concat(accessTokenForUser))
        ).andExpect(status().isNoContent())
                .andDo(
                        document(
                                "delete-member",
                                getRequestPreProcessor(),
                                getResponsePreProcessor(),
                                requestHeaders(
                                        List.of(
                                                headerWithName("Authorization").description("인증에 필요한 토큰 정보<br>Bearer Authentication(RFC 6750) " +
                                                        "Access Token (Ex.  <b>Bearer eyJhbG...</b>)<br> `Bearer ` 문자열을 access token 앞에 붙여야 한다.")
                                        )
                                ),
                                pathParameters(
                                        Arrays.asList(parameterWithName("member-id").description("회원 식별자 ID"))
                                )
                        )
                );
    }
}
