package com.crq.content.domain.dto;

import com.crq.content.domain.enums.AuditStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/4 15:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CheckDto {
    private Integer id;
    private Boolean showFlag;
    private AuditStatusEnum auditStatus;
    private String reason;
}
