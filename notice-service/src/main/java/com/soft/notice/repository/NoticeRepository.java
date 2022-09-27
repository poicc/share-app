package com.soft.notice.repository;

import com.soft.notice.entity.Notice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 16:10
 */

public interface NoticeRepository extends JpaRepository<Notice,Integer> {
    /**
     * 根据类型提交查询 根据日期排序
     * @param showFlag showFlag
     * @param sort sort
     * @return list
     */
    List<Notice> findByShowFlag(boolean showFlag, Sort sort);
}
