package com.crq.content.openfeign.fallback;

import com.crq.content.common.ResponseResult;
import com.crq.content.domain.entity.User;
import com.crq.content.openfeign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/8 08:57
 */
@Slf4j
@Component
public class UserServiceFallback implements UserService {
    @Override
    public ResponseResult getUser(int id) {
        log.info("fallback getUser");
        User user = User.builder().id(111).mobile("18851699003").nickname("降级方案返回用户").build();
        return ResponseResult.success(user);
    }
}
