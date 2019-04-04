package com.sunkuet02.springboot2.controllers;

import com.sunkuet02.springboot2.dto.response.ApiResponse;
import com.sunkuet02.springboot2.dto.response.Errors;
import com.sunkuet02.springboot2.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class GreetingsController {

    private GreetingsService greetingsService;

    @Autowired
    public GreetingsController(GreetingsService service) {
        this.greetingsService = service;
    }

    @GetMapping("hello")
    public ApiResponse hello() {
        return new ApiResponse(null, greetingsService.hello());
    }

    @GetMapping("errors")
    public ApiResponse errors() {
        return new ApiResponse(new Errors(1, "errors"), null);
    }

}
