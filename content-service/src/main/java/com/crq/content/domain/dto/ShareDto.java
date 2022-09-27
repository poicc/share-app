package com.crq.content.domain.dto;

import com.crq.content.domain.entity.Share;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 16:26
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShareDto {
    private Share share;
    private String nickName;
    private String avatar;
}
