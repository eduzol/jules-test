package com.example.mathservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/sum")
    public Integer sum(@RequestParam Integer a, @RequestParam Integer b) {
        return a + b;
    }

    @GetMapping("/multiply")
    public Integer multiply(@RequestParam Integer a, @RequestParam Integer b) {
        return a * b;
    }
}
