package com.korkeep.summer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// RunWith: JUnit 이외의 다른 실행자 실행 (SpringRunner)
@RunWith(SpringRunner.class)

// WebMvcTest: Web 관련 Spring Test Annotation
@WebMvcTest
public class ControllerTest {
    // Autowired: Bean 주입
    @Autowired
    // MockMvc: HTTP Get, Post 등 API 테스트
    private MockMvc mvc;

    @Test
    public void returnHello() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello"))              // /hello 주소로 HTTP get 요청
                .andExpect(status().isOk())                // HTTP header Status(200 = Ok) 검증
                .andExpect(content().string(hello));       // Content 내용 검증
    }

    @Test
    public void returnHelloDto() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name).param("amount", String.valueOf(amount)))   // 테스트용 파라미터 설정
                .andExpect(status().isOk())                                  // HTTP header Status(200 = Ok) 검증
                .andExpect(jsonPath("$.name", is(name)))           // JSON 응답값 필드별 검증
                .andExpect(jsonPath("$.amount", is(amount)));      // JSON 응답값 필드별 검증
    }
}