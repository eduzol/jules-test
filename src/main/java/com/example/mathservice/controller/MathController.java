package com.example.mathservice.controller;

import com.example.mathservice.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/sum")
    public ApiResponse sum(@RequestParam Integer a, @RequestParam Integer b) {
        return new ApiResponse(a + b);
    }

    @GetMapping("/multiply")
    public ApiResponse multiply(@RequestParam Integer a, @RequestParam Integer b) {
        return new ApiResponse(a * b);
    }
}
