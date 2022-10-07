package com.crq.content.repository;

import com.crq.content.domain.entity.MidUserShare;
import com.crq.content.domain.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/6 09:18
 */
public interface MidUserShareRepository extends JpaRepository<MidUserShare,Integer> {
}
