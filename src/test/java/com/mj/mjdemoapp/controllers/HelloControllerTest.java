package com.mj.mjdemoapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloControllerTest {

    @Test
    void testSayHello() {

        // Arrange
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();

        // Act
        String redirectionPage = controller.sayHello("Mayuresh", model);

        // Assert
        // JUnit 5 feature assertAll()
        assertAll(
                () -> assertEquals("welcome", redirectionPage),
                () -> assertEquals("Mayuresh", model.getAttribute("user"))
        );

        // JUnit 4 type assertions
        assertEquals("welcome", redirectionPage);
        assertEquals("Mayuresh", model.getAttribute("user"));
    }
}