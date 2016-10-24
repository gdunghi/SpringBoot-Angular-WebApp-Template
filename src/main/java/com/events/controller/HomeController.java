package com.events.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/sayHello")
    public String hello() {
        return "Hello World!";
    }
}
