package com.crq.content.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author: crq
 * @description:
 * @date: 2022/9/8 08:15
 */
@Configuration
public class LogConfig {

    @Bean
    Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
