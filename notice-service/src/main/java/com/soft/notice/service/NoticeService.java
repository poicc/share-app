package com.soft.notice.service;

import com.soft.notice.entity.Notice;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 16:29
 */

public interface NoticeService {

    /**
     * 查询最新公告
     * @return notice
     */
    Notice getLatestNotice();
}
