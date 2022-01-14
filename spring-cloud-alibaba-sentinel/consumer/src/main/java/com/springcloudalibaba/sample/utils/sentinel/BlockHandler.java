package com.springcloudalibaba.sample.utils.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public class BlockHandler {
    /**
     * sentinelUnionTest的兜底方法，放到单独类后必须时static
     * @param blockException
     * @return
     */
    public static String sentinelUnionTestBlockHandler(BlockException blockException) {
        return "单独类BlockHandler#sentinelUnionTestBlockHandler "
                + RandomUtils.nextInt(0, 1000)
                + " "
                + blockException.getMessage();
    }
}
