package com.soft.user.repository;

import com.soft.user.domain.entity.BonusEventLog;
import com.soft.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/6 09:41
 */
public interface BonusEventLogRepository extends JpaRepository<BonusEventLog,Integer> {
}
