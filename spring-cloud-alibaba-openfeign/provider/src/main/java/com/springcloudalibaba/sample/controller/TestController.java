package com.springcloudalibaba.sample.controller;

import org.apache.commons.lang3.RandomUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/openFeignProviderTest") //提供消费端调用的接口
    public String openFeignProviderTest() {
        return "provider-TestController#openFeignProviderTest" + RandomUtils.nextInt(0,100);
    }

}
