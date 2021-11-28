package com.springcloudalibaba.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
public class TestController {
    // 这里的服务地址填写注册到Nacos的应用名称
    private final String SERVER_URL = "http://nacos-provider-sample";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(){
        // 调用提供者的 /test 接口
        return restTemplate.getForObject(SERVER_URL+"/test",String.class);
    }
}
