package com.springcloudalibaba.sample.utils.sentinel;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public class ExceptionHandler {
    /**
     * 接口sentinelUnionTest的兜底方法，放到单独类后必须时static
     * @return
     */
    public static String sentinelUnionTestFallback(){
        return "单独类ExceptionHandler#sentinelUnionTestFallback "
                + RandomUtils.nextInt(0,1000);
    }
}
