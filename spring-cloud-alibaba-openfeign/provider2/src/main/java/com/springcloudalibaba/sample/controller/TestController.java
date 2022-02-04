package com.springcloudalibaba.sample.controller;

import org.apache.commons.lang3.RandomUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/openFeignProviderTest") //提供消费端调用的接口
    public String openFeignProviderTest() {
        //return "provider-TestController#openFeignProviderTest" + RandomUtils.nextInt(0,100);
        return "provider-TestController#openFeignProviderTest " + serverPort;
    }

    @GetMapping("/openFeignProviderTest2") //提供消费端调用的接口
    public String openFeignProviderTest2() {
        int a = 1 / 0 ; //此处必报错
        return "provider-TestController#openFeignProviderTest2" + RandomUtils.nextInt(0,100);
    }

}
