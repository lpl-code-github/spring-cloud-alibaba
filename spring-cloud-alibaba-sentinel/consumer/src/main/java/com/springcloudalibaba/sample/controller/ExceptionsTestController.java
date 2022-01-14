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
public class ExceptionsTestController {
  /**
   * 测试exceptionsToIgnore的方法
   * @return
   */
  @GetMapping("/exceptionsToIgnoreTest")
  @SentinelResource(
      value = "exceptionsToIgnoreTest",  // 资源名称为exceptionsToIgnoreTest
      fallback = "exceptionsToIgnoreTestFallback",  // 异常后的兜底方法为exceptionsToIgnoreTestFallback
      exceptionsToIgnore = {ArithmeticException.class}   // 忽略ArithmeticException异常
  )
  public String exceptionsToIgnoreTest() {
    int res = 1 / 0; // 此处模拟报错
    return "ExceptionsTestController#exceptionsToIgnoreTest "
            + RandomUtils.nextInt(0, 1000);
  }

  /**
   * 接口exceptionsToIgnoreTest的兜底方法
   * @return
   */
  public String exceptionsToIgnoreTestFallback() {
    return "ExceptionsTestController#exceptionsToIgnoreTestFallback "
            + RandomUtils.nextInt(0, 1000);
  }
}
