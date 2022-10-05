package com.soft.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author chenrongqi
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String cover;
    private String url;
    private Boolean isDisplay;
}
