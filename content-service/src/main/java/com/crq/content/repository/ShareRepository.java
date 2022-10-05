package com.crq.content.repository;

import com.crq.content.domain.entity.Share;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:42
 */


public interface ShareRepository extends JpaRepository<Share,Integer> {
    /**
     * 分页条件查询
     * @param auditStatus auditStatus
     * @param showFlag showFlag
     * @param pageable pageable
     * @return page
     */
    Page<Share> findAllByAuditStatusAndShowFlag(String auditStatus, boolean showFlag,Pageable pageable);

}
