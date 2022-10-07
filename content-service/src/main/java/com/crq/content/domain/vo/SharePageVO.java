package com.crq.content.domain.vo;

import com.crq.content.domain.entity.Share;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/4 22:43
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SharePageVO {
    List<Share> shareList;
    Integer totalPage;
    Long total;
    Boolean last;
    Boolean first;
}
