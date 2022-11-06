package com.example.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class BoardControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

//    브라우저에서 URL을 요청한것과 같은 환경을 구성해준다
    private MockMvc mockMvc;

//    각 테스트를 실행 시키기전에 이것을 먼저실행시켜라
    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    목록 테스트
//    getModelMap Model를 받아올때 사용
    @Test
    public void showTest() throws Exception{
//        get으로 보낼래, post로 보낼래?
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap().toString());
    }

//    등록 테스트
//    getViewName 응답할 경로를 출력
    @Test
    public void writeTest() throws Exception{
//        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/write")).andReturn().getModelAndView().getViewName());
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/write")
                .param("boardTitle", "ro 제목")
                .param("boardContent", "ro 내용")
                .param("boardWriter", "ro"))
                .andReturn().getModelAndView().getViewName());
    }

//    수정 테스트
    @Test
    public void updateTest() throws Exception{
//        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/update")
//        .param("boardNumber", String.valueOf(28L))).andReturn().getModelAndView().getModelMap().toString());
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/update")
                .param("boardNumber", "44")
                .param("boardTitle", "ro 수정")
                .param("boardContent", "ro 수정"))
                .andReturn().getModelAndView().getModelMap().toString());

    }

//    상세 테스트
    @Test
    public void readTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
                .param("boardNumber", String.valueOf(28L)))
                .andReturn().getModelAndView().getModelMap().toString());
    }

//    삭제 테스트
//    @Test
//    public void deleteTest() throws Exception{
//        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/delete")
//                .param("boardNumber", String.valueOf(28L)))
//                .andReturn().getModelAndView().getModelMap().toString());
//
//    }
    @Test
    public void deleteTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/board/delete")
                .param("boardNumber", "28"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}
