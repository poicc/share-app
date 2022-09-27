package com.crq.content.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.crq.content.domain.entity.Share;

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
     * 查所有
     * @return list
     */
    List<Share> findAll();

    /**
     * 资源
     * @param number number
     * @return
     */
    String getNumber(int number);

    /**
     * 资源的异常返回
     * @param number number
     * @param e 异常
     * @return string
     */
    String blockHandlerGetNumber(int number, BlockException e);
}
