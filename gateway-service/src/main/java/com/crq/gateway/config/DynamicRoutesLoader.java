package com.crq.gateway.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/27 20:02
 */

@Slf4j
//@Configuration
public class DynamicRoutesLoader implements InitializingBean {
    @Resource
    private NacosConfigManager configService;

    @Resource
    private NacosConfigProperties configProps;

    @Resource
    private DynamicRoutesListener dynamicRoutesListener;

    private static final String ROUTES_CONFIG = "routes-config.json";


    @Override
    public void afterPropertiesSet() throws Exception {
        // 首次加载配置
        String routes = configService.getConfigService().getConfig(ROUTES_CONFIG,configProps.getGroup(),10000);
        dynamicRoutesListener.receiveConfigInfo(routes);

        // 注册监听器
        configService.getConfigService().addListener(ROUTES_CONFIG,configProps.getGroup(),dynamicRoutesListener);
    }
}
