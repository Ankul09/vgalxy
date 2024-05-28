package com.mj.mjdemoapp.services;

import com.mj.mjdemoapp.json.AstroResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceTest {
    @Autowired
    private AstroService service;

    @Test
    void testGetPeopleInSpace(){
        String peopleInSpace = service.getPeopleInSpace();
        assertTrue(peopleInSpace.contains("people"));
        System.out.println(peopleInSpace);
    }

    @Test
    void testGetAstroResponse() {
        AstroResponse response = service.getAstroResponse();
        assertEquals("success", response.message());
        assertTrue(response.number() >= 0);
        assertEquals(response.people().size(), response.number());
        System.out.println(response);
    }

    @Test
    void testGetAstroResponseAsync() {
        AstroResponse response = service.getAstroResponseAsync();
        assertEquals("success", response.message());
        assertTrue(response.number() >= 0);
        assertEquals(response.people().size(), response.number());
        System.out.println(response);
    }
}