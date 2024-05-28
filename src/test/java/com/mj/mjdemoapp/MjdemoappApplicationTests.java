package com.mj.mjdemoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MjdemoappApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertNotNull(context);
        // 1
        int count = context.getBeanDefinitionCount();
        System.out.println("Spring Bean Count: " + count);

        // 2
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        // 3
        assertFalse(context.containsBean("restTemplate"));
        assertTrue((context.containsBean("restTemplateBuilder")));
    }

    @Test
    void getBean() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> context.getBean(RestTemplate.class));
    }
}
