package com.crq.content.controller;


import com.alibaba.fastjson.JSONObject;
import com.crq.content.auth.CheckAuthorization;
import com.crq.content.common.ResponseResult;
import com.crq.content.common.ResultCode;
import com.crq.content.domain.dto.CheckDto;
import com.crq.content.domain.dto.ShareDto;
import com.crq.content.domain.entity.Share;
import com.crq.content.domain.entity.User;
import com.crq.content.openfeign.UserService;
import com.crq.content.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 16:21
 */

@RestController
@Slf4j
@RequestMapping(value = "/share")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {
    private final ShareService shareService;
    private final UserService userService;

    @GetMapping("all")
//    @SentinelResource(value = "getAllShares", blockHandler = "getBlock")
    public ResponseResult getAllShares(@RequestParam(required = false,defaultValue = "false") boolean isCheck,
                                       @RequestParam(required = false,defaultValue = "0") int pageNum,
                                       @RequestParam(required = false,defaultValue = "10") int pageSize ) {
//        String result = shareService.getNumber(2022);
//        log.info(result);
//        if ("BLOCKED".equals(result)) {
//            return ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
//        }
        return ResponseResult.success(shareService.findAll(isCheck,pageNum,pageSize));
    }

    @GetMapping("{id}")
//    @SentinelResource(value = "getShareById")
    public ResponseResult getShareById(@PathVariable Integer id) {
        String result = shareService.getNumber(2025);
        log.info(result);
        if ("BLOCKED".equals(result)) {
            return ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
        } else {
            Share share = shareService.findById(id);
            Integer userId = share.getUserId();
            ResponseResult res = userService.getUser(userId);
            String jsonString = JSONObject.toJSONString(res.getData());
            JSONObject obj = JSONObject.parseObject(jsonString);
            User user = JSONObject.toJavaObject(obj, User.class);
            ShareDto shareDto = ShareDto.builder().share(share).nickName(user.getNickname()).avatar(user.getAvatar()).build();
            return ResponseResult.success(shareDto);
        }
    }

//    public ResponseResult getBlock(BlockException exception) {
//        log.info("接口被限流");
//        log.info(exception.toString());
//        return ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
//    }

    @PostMapping("/check")
    @CheckAuthorization("admin")
    public ResponseResult checkShareByd(@RequestBody CheckDto checkDto) {
        log.info(checkDto + ">>>>>>");
        Share share = shareService.auditShare(checkDto);
        return ResponseResult.success(share);
    }

}
