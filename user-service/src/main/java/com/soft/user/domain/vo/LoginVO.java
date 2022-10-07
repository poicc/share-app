package com.soft.user.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/5 16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginVO {
    private String token;
    private Integer userId;
}
