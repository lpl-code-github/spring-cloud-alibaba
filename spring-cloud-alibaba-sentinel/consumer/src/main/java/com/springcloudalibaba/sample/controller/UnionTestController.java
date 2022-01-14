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
public class UnionTestController {
  /**
   * sentinel组件测试方法fallback和blockHandler联合
   * @return
   */
  @GetMapping("/sentinelUnionTest")
  @SentinelResource(
      value = "sentinelUnionTest",
      blockHandler = "sentinelUnionTestBlockHandler",
      fallback = "sentinelUnionTestFallback")
  public String sentinelUnionTest() {
    int res = 1 / 0; // 此处必然报错
    return "UnionTestController#sentinelUnionTest "
            + RandomUtils.nextInt(0, 1000);
  }

  /**
   * sentinelUnionTest的兜底方法
   * @return
   */
  public String sentinelUnionTestFallback() {
    return "UnionTestController#sentinelUnionTestFallback "
            + RandomUtils.nextInt(0, 1000);
  }

  /**
   * sentinelUnionTest的兜底方法
   * @param blockException
   * @return
   */
  public String sentinelUnionTestBlockHandler(BlockException blockException) {
    return "UnionTestController#sentinelUnionTestBlockHandler "
            + RandomUtils.nextInt(0, 1000)
            + " "
            + blockException.getMessage();
  }
}
