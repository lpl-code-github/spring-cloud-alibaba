package com.springcloudalibaba.sample.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@RestController
public class FallbackTestController {
  /**
   * 测试fallback的方法
   * @param params
   * @return
   */
  @GetMapping("/fallbackTest")
  // 资源名称为fallbackTest，异常后的兜底方法为fallbackHandler
  @SentinelResource(value = "fallbackTest",fallback = "fallbackHandler")
  public String fallbackTest(String params) {
    int res = 1 / 0; // 此处模拟报错
    return "FallbackTestController#fallbackTest "
            + RandomUtils.nextInt(0, 1000);
  }

  /**
   * 接口fallbackTest的兜底方法
   * @param params
   * @return
   */
  public String fallbackHandler(String params){
    return "FallbackTestController#fallbackHandler "
            + RandomUtils.nextInt(0, 1000);
  }
}
