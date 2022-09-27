package com.soft.user.service.impl;


import com.soft.user.domain.dto.UserDto;
import com.soft.user.domain.entity.User;
import com.soft.user.repository.UserRepository;
import com.soft.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User login(UserDto userDto) {
        return userRepository.findByMobileAndPassword(userDto.getUsername(), userDto.getPassword());
    }
}
