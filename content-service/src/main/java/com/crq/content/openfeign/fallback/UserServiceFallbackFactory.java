package com.crq.content.openfeign.fallback;

import com.crq.content.common.ResponseResult;
import com.crq.content.domain.entity.User;
import com.crq.content.openfeign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/8 09:31
 */
@Component
@Slf4j
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
    /**
     * 可以捕捉到具体的异常cause
     * @param cause cause
     * @return UserService
     */
    @Override
    public UserService create(Throwable cause) {
        return id -> {
            log.info("fallback factory method test" + cause);
            User user = User.builder().id(111).mobile("18851699003").nickname("降级方案返回用户").avatar("default.jpg").build();
            return ResponseResult.success(user);
        };
    }
}
