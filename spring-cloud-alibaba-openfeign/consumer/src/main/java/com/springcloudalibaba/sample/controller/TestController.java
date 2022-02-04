package com.springcloudalibaba.sample.controller;

import com.springcloudalibaba.sample.service.OpenFeignTestService;
import com.springcloudalibaba.sample.utils.openfeign.OpenFeignTestServiceFallback;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;


@RestController
public class TestController {

    @Autowired
    private OpenFeignTestService openFeignTestService;

    @GetMapping("/openFeginTest")
    public String test(){
        return openFeignTestService.openFeignProviderTest();
    }

    @GetMapping("/openFeginTest2")
    public String test2(){
        return openFeignTestService.openFeignProviderTest2();
    }

}
