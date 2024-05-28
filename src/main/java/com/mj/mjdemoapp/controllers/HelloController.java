package com.mj.mjdemoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello") // maps tp http://localhost:8080/hello?name=Mj
    public String sayHello(@RequestParam(defaultValue = "World") String name,
                           Model model) {
        model.addAttribute("user", name);
        return "welcome"; // forward to src/main/resources/templates/welcome.html
    }
}
