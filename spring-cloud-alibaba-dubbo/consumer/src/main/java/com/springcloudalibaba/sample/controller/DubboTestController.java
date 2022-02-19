package com.springcloudalibaba.sample.controller;

import com.springcloudalibaba.dubbo.entity.Params;
import com.springcloudalibaba.dubbo.entity.Result;
import com.springcloudalibaba.dubbo.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
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

    @RequestMapping("/dubboObjectTest")
    public Result dubboObjectTest(){
        Params params = new Params().setName("lpl");
        return testService.dubboObjectTest(params);
    }
}
