package com.soft.user.controller;

import com.soft.user.common.ResponseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/3 09:51
 */
@RestController
@Slf4j
@RequestMapping(value = "/pre")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    @GetMapping("/users/test")
    public ResponseResult preTest() {
        return ResponseResult.success("前缀测试");
    }
}
