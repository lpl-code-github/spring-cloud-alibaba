package com.springcloudalibaba.sample.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GenericConfiguration {
    @LoadBalanced//标记此注解后，RestTemplate就具有了客户端负载均衡的能力
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
