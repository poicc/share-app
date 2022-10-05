package com.crq.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/3 09:01
 */
@RestController
public class FallBackController {

    @GetMapping("/subscriptionServiceFallBack")
    public String userServiceFallBackMethod() {
        return "Subscription Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/capabilityServiceFallBack")
    public String capabilityServiceFallBackMethod() {
        return "Capability Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/homeServiceFallBack")
    public String homeServiceFallBackMethod() {
        return "Home Service is taking longer than Expected." +
                " Please try again later";
    }
}

