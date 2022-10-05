package com.soft.user.service.impl;


import com.google.common.collect.Maps;
import com.soft.user.domain.dto.UserDto;
import com.soft.user.domain.entity.User;
import com.soft.user.repository.UserRepository;
import com.soft.user.service.UserService;
import com.soft.user.utils.JwtOperator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:15
 */

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtOperator jwtOperator;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String login(UserDto userDto) {
        User user = userRepository.findByMobileAndPassword(userDto.getUsername(), userDto.getPassword());
        if(user != null) {
            HashMap<String,Object> objectHashMap = Maps.newHashMap();
            objectHashMap.put("id",user.getId());
            objectHashMap.put("role",user.getRoles());
            objectHashMap.put("nickname",user.getNickname());
            String token = jwtOperator.generateToken(objectHashMap);
            return token;
        } else {
            return null;
        }
    }
}
