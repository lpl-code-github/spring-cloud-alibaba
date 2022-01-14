package com.springcloudalibaba.sample.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.springcloudalibaba.sample.utils.sentinel.BlockHandler;
import com.springcloudalibaba.sample.utils.sentinel.ExceptionHandler;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@RestController
public class UnionTestOptimizeController {
    /**
     * sentinel组件测试方法fallback和blockHandler联合
     * 指定fallback和blockHandler的类
     * @return
     */
    @GetMapping("/sentinelUnionTestOptimize")
    @SentinelResource(
            value = "sentinelUnionTestOptimize",
            blockHandler = "sentinelUnionTestBlockHandler",
            blockHandlerClass = BlockHandler.class,
            fallback = "sentinelUnionTestFallback",
            fallbackClass = ExceptionHandler.class
    )
    public String sentinelUnionTest() {
        int res = 1 / 0; // 此处必然报错
        return "UnionTestController#sentinelUnionTest "
                + RandomUtils.nextInt(0, 1000);
    }
}
