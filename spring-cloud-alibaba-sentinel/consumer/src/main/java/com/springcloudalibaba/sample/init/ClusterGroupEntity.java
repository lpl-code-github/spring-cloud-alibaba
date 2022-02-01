package com.springcloudalibaba.sample.init;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Data
public class ClusterGroupEntity implements Serializable {
    private String machineId; // 机器id
    private String ip; //ip 地址
    private Integer port; // 端口
    private Set<String> clientSet;
}
