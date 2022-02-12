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
public class Result {
    private Integer code;
    private String description;
}
