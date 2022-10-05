package com.crq.content.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/4 21:21
 */

@Getter
@AllArgsConstructor
public enum AuditStatusEnum {
    /**
     * 待审核
     */
    NOT_YET,
    /**
     * 审核通过
     */
    PASS,
    /**
     * 审核不通过
     */
    REJECT
}
