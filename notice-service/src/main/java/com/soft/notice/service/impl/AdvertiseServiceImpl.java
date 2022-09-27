package com.soft.notice.service.impl;


import com.soft.notice.common.ResponseResult;
import com.soft.notice.entity.Advertise;
import com.soft.notice.repository.AdvertiseRepository;
import com.soft.notice.service.AdvertiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdvertiseServiceImpl implements AdvertiseService {
    private final AdvertiseRepository advertiseRepository;
    @Override
    public ResponseResult findAll() {
        List<Advertise> list = advertiseRepository.findAll();
        return ResponseResult.success(list);
    }
}
