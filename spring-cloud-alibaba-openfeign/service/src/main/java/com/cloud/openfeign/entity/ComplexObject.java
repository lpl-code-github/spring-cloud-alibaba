package com.cloud.openfeign.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Data
@Accessors(chain = true)
public class ComplexObject {
    /*
        引用类对象
     */
    private Params params;
}
