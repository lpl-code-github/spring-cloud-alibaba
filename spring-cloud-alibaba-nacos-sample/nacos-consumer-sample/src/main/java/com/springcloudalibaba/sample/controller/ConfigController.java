package com.springcloudalibaba.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 通过Spring Cloud的原生注解 实现配置自动更新
public class ConfigController {

    @Value("${custom.info}")
    private String config;

    @GetMapping("/getConfig")
    public String getConfig(){
        return config;
    }
}
