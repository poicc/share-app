package com.crq.content.openfeign;

import com.crq.content.common.ResponseResult;
import com.crq.content.openfeign.fallback.UserServiceFallback;
import com.crq.content.openfeign.fallback.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:54
 */
//@FeignClient(value = "user-center",path = "/user",fallback = UserServiceFallback.class)
@FeignClient(value = "user-service",path = "/user",fallbackFactory = UserServiceFallbackFactory.class)
public interface UserService {
    /**
     * 根据id查询用户
     * @param id id
     * @return ResponseResult
     */
    @GetMapping("{id}")
    ResponseResult getUser(@PathVariable(value="id") int id);
}
