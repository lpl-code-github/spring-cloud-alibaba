package com.springcloudalibaba.sample.service;

import com.springcloudalibaba.dubbo.entity.Params;
import com.springcloudalibaba.dubbo.entity.Result;
import com.springcloudalibaba.dubbo.service.TestService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Service
public class TestServiceImpl implements TestService {
    @Value("${server.port}")
    private String serverPort;

    @Override
    public String dubboTest(String message) { // 服务提供者具体实现的方法
        return "我是服务提供者"+ serverPort +"，已接受到消息：" + message;
    }

    @Override
    public Result dubboObjectTest(Params params) {
        Result result = new Result();
        result.setCode(200)
                .setDescription("我是服务提供者：已收到消息：name="+params.getName());
        return result;
    }
}
