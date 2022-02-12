package com.springcloudalibaba.sample.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Configuration
public class OpenFeignLoggerConfiguration {
    @Bean
    public Logger.Level openFeignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
