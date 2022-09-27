package com.crq.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:37
 */

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.crq.content"})
//@EnableFeignClients(clients = {com.crq.content.openfeign.UserService.class})
public class ContentCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class,args);
    }
}
