//package com.odyssey.controllers;
//
//import ApiResponse;
//import GreetingsService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
////@RunWith(SpringRunner.class)
////@WebMvcTest(GreetingsController.class)
//public class GreetingsControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    GreetingsService greetingsService;
//
//    @Test
//    public void hello() throws Exception {
//        ApiResponse apiResponse = new ApiResponse(null, "hello");
//
//        given(greetingsService.hello()).willReturn(String.valueOf(apiResponse.getData()));
//
//        mockMvc.perform(get("/hello")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.metadata").isEmpty())
//                .andExpect(jsonPath("$.data").value("hello"));
//    }
//
//    @Test
//    public void metadata() throws Exception {
//
//        mockMvc.perform(get("/metadata")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data").isEmpty())
//                .andExpect(jsonPath("$.metadata.code").value(1))
//                .andExpect(jsonPath("$.metadata.description").value("metadata"));
//    }
//}