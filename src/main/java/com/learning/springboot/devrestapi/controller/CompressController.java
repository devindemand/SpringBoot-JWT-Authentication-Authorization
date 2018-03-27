package com.learning.springboot.devrestapi.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompressController {
    @RequestMapping(value = "/demo")
    public String demo() {
        return "Spring boot compressed response.";
    }
}