package com.springcloudalibaba.sample.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.springcloudalibaba.sample.rule.CustomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Configuration // 标记这是个配置类
public class RibbonConfiguration {
//    @Bean  // 交给Spring容器初始化的标识
//    public IRule ribbonRule() {
//        return new RandomRule();  // 负载均衡规则，改为随机
//    }


    @Bean  // 交给Spring容器初始化的标识
    public IRule ribbonRule() {
        return new CustomRule();  // 负载均衡规则，改为随机
    }
}