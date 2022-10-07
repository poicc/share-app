package com.crq.content.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/6 09:16
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class MidUserShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer shareId;

    private Integer userId;
}
