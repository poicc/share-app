package com.crq.content.service;

import com.crq.content.domain.dto.CheckDto;
import com.crq.content.domain.dto.ShareDto;
import com.crq.content.domain.entity.Share;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:42
 */
public interface ShareService {

    /**
     * 根据id查找
     * @param id id
     * @return share
     */
    Share findById(Integer id);

    /**
     * 分页查所有
     * @param isCheck isCheck
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return list
     */
    Page<Share> findAll(boolean isCheck, int pageNum, int pageSize);

    /**
     * 资源
     * @param number number
     * @return
     */
    String getNumber(int number);

    /**
     * 审核分享
     * @param checkDto checkDto
     * @return share
     */
    Share auditShare(CheckDto checkDto);

    /**
     * 资源的异常返回
     * @param number number
     * @param e 异常
     * @return string
     */
//    String blockHandlerGetNumber(int number, BlockException e);
}
