package com.springcloudalibaba.sample.controller;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;


@RestController
public class TestController {
    // 这里的服务地址填写注册到Nacos的应用名称
    private final String SERVER_URL = "http://provider";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 调用提供者test接口
     * @return
     */
    @GetMapping("/test")
    public String test(){
        // 调用提供者的 /test 接口
        return restTemplate.getForObject(SERVER_URL+"/test?origin=consumer",String.class);
    }

    /**
     *  sentinel测试组件
     * @return
     */
    @GetMapping("/sentinelTest")
    public String sentinelTest() throws InterruptedException {
        // TimeUnit.SECONDS.sleep(1);
        int i = 1/0; // 除数不能为0，此处必然会报错
        return "TestController#sentinelTest " + RandomUtils.nextInt(0,10000);
    }

    /**
     *  sentinel测试组件B
     * @return
     */
    @GetMapping("/sentinelTestB")
    public String sentinelTestB(){
        return "TestController#sentinelTestB " + RandomUtils.nextInt(0,10000);
    }

    /**
     *  sentinel测试组件C
     * @return
     */
    @GetMapping("/sentinelTestC")
    public String sentinelTestC(){
        return "TestController#sentinelTestC " + RandomUtils.nextInt(0,10000);
    }
}
