package com.springcloudalibaba.dubbo.service;

import com.springcloudalibaba.dubbo.entity.Params;
import com.springcloudalibaba.dubbo.entity.Result;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public interface TestService {
    String dubboTest(String message); // 测试方法
    Result dubboObjectTest(Params params); //测试传递对象的方法
}
