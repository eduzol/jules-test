package com.example.mathservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Added for more specific JSON checks if needed

@WebMvcTest(MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSum_success() throws Exception {
        mockMvc.perform(get("/sum")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"result\":8}"));
    }

    @Test
    public void testMultiply_success() throws Exception {
        mockMvc.perform(get("/multiply")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"result\":15}"));
    }

    @Test
    public void testSum_invalidInput_characterA() throws Exception {
        mockMvc.perform(get("/sum")
                .param("a", "abc")
                .param("b", "5"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().json("{\"result\":\"Error: Invalid input. Please provide integers only.\"}"));
    }

    @Test
    public void testSum_invalidInput_characterB() throws Exception {
        mockMvc.perform(get("/sum")
                .param("a", "5")
                .param("b", "xyz"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().json("{\"result\":\"Error: Invalid input. Please provide integers only.\"}"));
    }

    @Test
    public void testMultiply_invalidInput_characterA() throws Exception {
        mockMvc.perform(get("/multiply")
                .param("a", "def")
                .param("b", "3"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().json("{\"result\":\"Error: Invalid input. Please provide integers only.\"}"));
    }
}
