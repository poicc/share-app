package com.soft.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/6 09:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserAddBonusDto {
    private Integer userId;
    private Integer bonus;
}
