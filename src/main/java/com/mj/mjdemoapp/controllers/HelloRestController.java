package com.mj.mjdemoapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("rest")
    public Greeting greet(@RequestParam(defaultValue = "World") String name) {
        return new Greeting("Hello, " + name + "!");
    }
}

// record feature only available in Java 16+
// these are immutable, once you instantiate you cant change value
// auto generates toString(), equals() and hashCode()
record Greeting(String message) {
}