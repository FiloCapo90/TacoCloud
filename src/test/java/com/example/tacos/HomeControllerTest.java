package com.example.tacos;

import static org.hamcrest.Matchers.containsString;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)   //Web test for HomeController. Special annotation provided by Spring Boot that
//arranges for the test to run in the context of a Spring MVC application
public class HomeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;   //Injects MockMvc
    
    @Test
    public void testHomePage() throws Exception{
        mockMvc.perform(get("/")) //Perform GET/
        
        .andExpect(status().isOk())  //Expects HTTP 200
                
        .andExpect(view().name("home")) //Expects home view
                
        .andExpect(content().string(containsString("Welcome to...")));  //Expects Welcome to...
        
    }
}
