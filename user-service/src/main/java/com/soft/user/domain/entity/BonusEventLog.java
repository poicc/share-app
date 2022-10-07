package com.soft.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/6 09:38
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BonusEventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer value;
    private String event;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private String description;

}
