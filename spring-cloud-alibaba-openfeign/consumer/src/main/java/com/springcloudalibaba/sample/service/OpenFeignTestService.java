package com.springcloudalibaba.sample.service;

import com.springcloudalibaba.sample.utils.openfeign.OpenFeignTestServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
// 表示调用调用服务名为provider,fallback异常、限流等的自定义处理逻辑在OpenFeignTestServiceFallback类中
@FeignClient(value = "provider",fallback = OpenFeignTestServiceFallback.class)
public interface OpenFeignTestService {
    @GetMapping("openFeignProviderTest")
    public String openFeignProviderTest();
}
