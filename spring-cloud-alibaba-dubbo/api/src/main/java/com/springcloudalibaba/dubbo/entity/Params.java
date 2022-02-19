package com.springcloudalibaba.dubbo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Data
@Accessors(chain = true)
public class Params implements Serializable {
    private String name;
}
