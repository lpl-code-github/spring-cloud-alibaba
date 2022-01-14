package com.springcloudalibaba.sample.controller;

import org.apache.commons.lang3.RandomUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "provider test方法" + RandomUtils.nextInt(0,100);
    }
}
