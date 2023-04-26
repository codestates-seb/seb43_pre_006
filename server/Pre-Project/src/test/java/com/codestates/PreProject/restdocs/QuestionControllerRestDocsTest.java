package com.codestates.PreProject.restdocs;

import com.codestates.PreProject.auth.interceptor.JwtParseInterceptor;
import com.codestates.PreProject.auth.jwt.JwtTokenizer;
import com.codestates.PreProject.auth.utils.CustomAuthorityUtils;
import com.codestates.PreProject.config.SecurityConfiguration;
import com.codestates.PreProject.helper.StubData;
import com.codestates.PreProject.member.repository.MemberRepository;
import com.codestates.PreProject.member.service.MemberService;
import com.codestates.PreProject.question.controller.QuestionController;
import com.codestates.PreProject.question.dto.QuestionDto;
import com.codestates.PreProject.question.entity.Question;
import com.codestates.PreProject.question.mapper.CommentOfQuestionMapper;
import com.codestates.PreProject.question.mapper.QuestionMapper;
import com.codestates.PreProject.question.service.CommentOfQuestionService;
import com.codestates.PreProject.question.service.QuestionService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.codestates.PreProject.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.codestates.PreProject.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import({SecurityConfiguration.class, JwtTokenizer.class, CustomAuthorityUtils.class})
@WebMvcTest(QuestionController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuestionControllerRestDocsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionMapper mapper;

    @Autowired
    private Gson gson;

    @MockBean
    private CommentOfQuestionMapper commentMapper;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private JwtParseInterceptor jwtParseInterceptor;

    @MockBean
    private CommentOfQuestionService commentOfQuestionService;

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
    public void postQuestionTest() throws Exception {
        QuestionDto.Post post = new QuestionDto.Post("제목테스트", "내용테스트");
        String content = gson.toJson(post);

        given(mapper.questionPostDtoToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());

        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(new Question());

//        Mockito.when(jwtParseInterceptor.preHandle(Mockito.any(HttpServletRequest.class), Mockito.any(HttpServletResponse.class), Mockito.any(Object.class)))
//                .thenReturn(true);
//
        QuestionDto.Response mockResultQuestion = new QuestionDto.Response();
        mockResultQuestion.setQuestionId(1L);

        given(mapper.questionToQuestionResponseDto(Mockito.any(Question.class))).willReturn(mockResultQuestion);


        ResultActions actions = mockMvc.perform(
                post("/questions")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        actions
                .andExpect(status().isCreated())
                .andDo(document("post-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("내용")
                        )
                ));

    }
}
