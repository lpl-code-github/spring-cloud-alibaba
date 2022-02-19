package com.springcloudalibaba.sample.service;

import com.springcloudalibaba.dubbo.service.TestService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String dubboTest(String message) { // 服务提供者具体实现的方法
        return "我是服务提供者，已接受到消息：" + message;
    }
}
