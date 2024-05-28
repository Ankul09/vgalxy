package com.mj.mjdemoapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(HelloController.class)
public class HelloControllerMockMvcTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void autoWiringWorked() {
        assertNotNull(mvc);
    }

    @Test
    void testHelloWithoutName() throws Exception {
        // This 'performs' a mock request to our API and we assert results
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user", "World"));
    }

    @Test
    void testHelloName() throws Exception {
        // This 'performs' a mock request to our API and we assert results
        mvc.perform(get("/hello").param("name", "Mayuresh"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user", "Mayuresh"));
    }
}
