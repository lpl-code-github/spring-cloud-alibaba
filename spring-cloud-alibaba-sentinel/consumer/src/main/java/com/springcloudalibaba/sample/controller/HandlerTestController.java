package com.springcloudalibaba.sample.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@RestController
public class HandlerTestController {
  @GetMapping("/blockHandlerTest")
  // 资源名称为blockHandlerTest 违反规则后的兜底方法是blockHandlerTestHandler
  @SentinelResource(value = "blockHandlerTest", blockHandler = "blockHandlerTestHandler")
  public String blockHandlerTest(String params) {
    return "HandlerTestController#blockHandlerTest " + RandomUtils.nextInt(0, 1000);
  }

  /**
   * 接口blockHandlerTest的兜底方法
   *
   * @param params
   * @param blockException
   * @return
   */
  public String blockHandlerTestHandler(String params, BlockException blockException) {
    return "HandlerTestController#blockHandlerTestHandler "
        + RandomUtils.nextInt(1, 1000)
        + " "
        + blockException.getMessage();
  }
}
