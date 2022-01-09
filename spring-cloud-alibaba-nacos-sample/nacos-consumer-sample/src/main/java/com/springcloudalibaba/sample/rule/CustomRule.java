package com.springcloudalibaba.sample.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @describe
 */
public class CustomRule extends AbstractLoadBalancerRule {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Server choose(Object key) { // 选择某个服务
        return choose(getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer loadBalancer, Object key) {// 选择某个服务，真正“干活”的方法
        List<Server> allServers = loadBalancer.getAllServers(); // 获取全部服务列表
        int requestNumber = count.incrementAndGet(); // 累加并得到值 请求次数
        if (requestNumber >= Integer.MAX_VALUE) { // 如果调用次数大于等于int的最大值，则重置，否则会变成负值
            count = new AtomicInteger(0); // 重置为0
        }
        if (null != allServers) {
            int size = allServers.size();
            if (size > 0) {
                int index = requestNumber % size; // 请求次数 % 服务列表个数得到要选择的服务下标
                Server server = allServers.get(index);
                if (null == server || !server.isAlive()) { // 如果服务为null或者服务不可用返回null
                    return null;
                }
                return server;
            }
        }
        return null;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) { // 初始化的操作
    }
}
