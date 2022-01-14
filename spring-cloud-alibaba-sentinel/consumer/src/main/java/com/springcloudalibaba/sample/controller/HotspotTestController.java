package com.springcloudalibaba.sample.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import javafx.scene.chart.ValueAxis;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@RestController
@Slf4j
public class HotspotTestController {
  /**
   * 热点参数测试接口
   *
   * @return
   */
  @GetMapping("/testHotKeyA")
  @SentinelResource(value = "testHotKeyA", blockHandler = "blockTestHotKeyA")
  public String testHotKeyA(
      @RequestParam(value = "orderId", required = false) String orderId,
      @RequestParam(value = "userId", required = false) String userId) {
    log.info("orderId:"+orderId);
    return "HotspotTestController#testHotKeyA " + RandomUtils.nextInt(0, 1000);
  }

  /**
   * 热点参数测试接口testHotKeyA的兜底方法
   * @param orderId
   * @param userId
   * @param blockException
   * @return
   */
  public String blockTestHotKeyA(String orderId, String userId, BlockException blockException) {
    return "HotspotTestController#blockTestHotKeyA "
        + RandomUtils.nextInt(0, 1000)
        + " "
        + blockException.getMessage();
  }
}
