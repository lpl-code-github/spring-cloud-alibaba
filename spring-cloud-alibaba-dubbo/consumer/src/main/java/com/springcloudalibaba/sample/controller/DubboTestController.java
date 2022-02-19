package com.springcloudalibaba.sample.controller;

import com.springcloudalibaba.dubbo.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@RestController
public class DubboTestController {
    @Reference
    private TestService testService;

    @RequestMapping("/dubboTest")
    public String dubboTest(){
        return testService.dubboTest("Here is the consumer!");
    }
}
