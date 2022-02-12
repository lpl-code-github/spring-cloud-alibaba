package com.springcloudalibaba.sample.service;

import com.cloud.openfeign.entity.Params;
import com.springcloudalibaba.sample.utils.openfeign.OpenFeignTestServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
// 表示调用调用服务名为provider,fallback异常、限流等的自定义处理逻辑在OpenFeignTestServiceFallback类中
@FeignClient(value = "${provider.name}", fallback = OpenFeignTestServiceFallback.class)
public interface OpenFeignTestService {
    @GetMapping("openFeignProviderTest")
    public String openFeignProviderTest();

    @GetMapping("openFeignProviderTest2")
    public String openFeignProviderTest2();

    @GetMapping("paramsProviderTest")
    public String paramsProviderTest(@RequestParam("name") String name, @RequestParam("id") Integer id);

    @GetMapping("springQueryMapProviderTest")
    public String springQueryMapProviderTest(@SpringQueryMap Params params);
}
