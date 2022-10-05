package com.crq.gateway.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.listener.Listener;
import com.google.common.util.concurrent.ListenableFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/27 19:57
 */
@Slf4j
//@Component
public class DynamicRoutesListener implements Listener {
    @Resource
    private GatewayService gatewayService;

    @Override
    public Executor getExecutor() {
        log.info("getExecutor");
        return null;
    }

    /**
     * 使用json转换 将plain text变成RouteDefintion
     * @param configInfo
     */
    @Override
    public void receiveConfigInfo(String configInfo) {
        log.info("received routes changes {}",configInfo);

        List<RouteDefinition> definitionList = JSON.parseArray(configInfo,RouteDefinition.class);
        gatewayService.updateRoutes(definitionList);
    }
}
