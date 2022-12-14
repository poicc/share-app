package com.soft.user.controller;


import com.soft.user.auth.CheckLogin;
import com.soft.user.common.ResponseResult;
import com.soft.user.common.ResultCode;
import com.soft.user.domain.dto.UserDto;
import com.soft.user.domain.entity.User;
import com.soft.user.domain.vo.LoginVO;
import com.soft.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:19
 */

@RestController
@Slf4j
@RequestMapping(value = "/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    @CheckLogin
    public ResponseResult getUserById(@PathVariable Integer id) throws InterruptedException {
        return ResponseResult.success(userService.findById(id));
    }

    @PostMapping(value = "/login")
    public ResponseResult login(@RequestBody UserDto userDto) {
        LoginVO login = userService.login(userDto);
        if(login == null) {
            return ResponseResult.failure(ResultCode.USER_SIGN_IN_FAIL);
        } else {
            return ResponseResult.success(login);
        }
    }


}
