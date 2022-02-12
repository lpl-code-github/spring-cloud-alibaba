package com.springcloudalibaba.sample.utils.openfeign;

import com.cloud.openfeign.entity.ComplexObject;
import com.cloud.openfeign.entity.Params;
import com.cloud.openfeign.entity.Result;
import com.springcloudalibaba.sample.service.OpenFeignTestService;
import org.springframework.stereotype.Component;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Component
public class OpenFeignTestServiceFallback implements OpenFeignTestService {
    /**
     * openFeignProviderTest接口的兜底方法
     * @return
     */
    @Override
    public String openFeignProviderTest() {
        return "这里是兜底方法";
    }

    @Override
    public String openFeignProviderTest2() {
        return "这里是兜底方法";
    }

    @Override
    public String paramsProviderTest(String name, Integer id) {
        return "这里是兜底方法";
    }

    @Override
    public String springQueryMapProviderTest(Params params) {
        return "这里是兜底方法";
    }

    @Override
    public Result complexObjectProviderTest(ComplexObject complexObject) {
        Result result = new Result();
        result.setCode(500)
                .setDescription("这里是兜底方法");
        return result;
    }

}
