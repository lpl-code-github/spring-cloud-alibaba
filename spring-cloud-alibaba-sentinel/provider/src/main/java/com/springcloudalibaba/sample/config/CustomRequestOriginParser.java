package com.springcloudalibaba.sample.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Component
@Slf4j
public class CustomRequestOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        // 区分来源：本质通过request域获取来源标识
        String origin = httpServletRequest.getParameter("origin");
        log.info(origin);
        // 授权规则必须判断
        if(StringUtils.isEmpty(origin)){
            throw new RuntimeException("origin不能为空");
        }
        // 最后返回origin交给sentinel流控匹配处理
        return origin;
    }
}
