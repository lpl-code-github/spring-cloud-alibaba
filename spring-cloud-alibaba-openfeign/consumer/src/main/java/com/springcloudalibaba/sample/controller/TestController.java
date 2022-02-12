package com.springcloudalibaba.sample.controller;

import com.cloud.openfeign.entity.Params;
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

    @GetMapping("/openFeignTest")
    public String test() {
        return openFeignTestService.openFeignProviderTest();
    }

    @GetMapping("/openFeignTest2")
    public String test2() {
        return openFeignTestService.openFeignProviderTest2();
    }

    @GetMapping("/openFeignParamsTest")
    public String test3() {
        return openFeignTestService.paramsProviderTest("lpl", 1);
    }

    @GetMapping("/openFeignParamsTest2")
    public String test4() {
        Params params = new Params();
        params.setId(1)
                .setName("lpl");
        return openFeignTestService.springQueryMapProviderTest(params);
    }

}
