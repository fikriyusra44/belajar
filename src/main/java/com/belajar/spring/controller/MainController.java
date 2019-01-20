package com.belajar.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @GetMapping(value = "/")
    public String home() {
        return "Belajar spring boot";
    }
}
