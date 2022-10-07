package com.crq.content.service.impl;

import com.crq.content.domain.entity.MidUserShare;
import com.crq.content.repository.MidUserShareRepository;
import com.crq.content.service.MidUserShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/6 09:20
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MidUserShareServiceImpl implements MidUserShareService {
    private final MidUserShareRepository midUserShareRepository;


    @Override
    public void insert(MidUserShare midUserShare) {
        midUserShareRepository.save(midUserShare);
    }
}
