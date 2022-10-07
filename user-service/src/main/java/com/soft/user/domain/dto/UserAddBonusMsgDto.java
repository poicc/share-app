package com.soft.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/6 09:48
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddBonusMsgDto {
    private Integer userId;

    private Integer value;
    private String event;

    /**
     * 修改时间
     */
    private String description;
}
