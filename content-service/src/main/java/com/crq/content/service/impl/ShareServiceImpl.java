package com.crq.content.service.impl;


import com.crq.content.domain.dto.CheckDto;
import com.crq.content.domain.dto.ShareDto;
import com.crq.content.domain.entity.Share;
import com.crq.content.domain.enums.AuditStatusEnum;
import com.crq.content.repository.ShareRepository;
import com.crq.content.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:43
 */

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareServiceImpl implements ShareService {
    private final ShareRepository shareRepository;

    @Override
    public Share findById(Integer id) {
        return shareRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Share> findAll(boolean isCheck,int pageNum,int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<Share> page;
        if(isCheck) {
            page = shareRepository.findAllByAuditStatusAndShowFlag(AuditStatusEnum.PASS.toString(), true,pageable);
        } else {
            page = shareRepository.findAll(pageable);
        }

        return page;
    }

    @Override
//    @SentinelResource(value = "getNumber",blockHandler = "blockHandlerGetNumber")
    public String getNumber(int number) {
        return "number = {" + number + "}";
    }

    @Override
    public Share auditShare(CheckDto checkDto) {
        Share share = shareRepository.findById(checkDto.getId()).orElse(null);
        if(!Objects.equals("NOT_YET",share.getAuditStatus())) {
            throw new IllegalArgumentException("参数非法！该分享已审核！");
        }
        share.setAuditStatus(checkDto.getAuditStatus().toString());
        share.setReason(checkDto.getReason());
        share.setShowFlag(checkDto.getShowFlag());
        return shareRepository.saveAndFlush(share);
    }

//    @Override
//    public String blockHandlerGetNumber(int number, BlockException e) {
//        return "BLOCKED";
//    }
}
