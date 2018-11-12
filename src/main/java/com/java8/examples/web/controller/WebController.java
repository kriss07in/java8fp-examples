package com.java8.examples.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {
    
    @RequestMapping("/hello")
    public String printHello() {
        return "Hello, WORLD!!!!";
    }

}