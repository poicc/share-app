package com.crq.content.repository;

import com.crq.content.domain.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:42
 */


public interface ShareRepository extends JpaRepository<Share,Integer> {
}
