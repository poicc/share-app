package com.soft.notice.controller;


import com.soft.notice.common.ResponseResult;
import com.soft.notice.service.AdvertiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertise")
@Slf4j
@RefreshScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdvertiseController {

    private final AdvertiseService advertiseService;

    @GetMapping("/all")
    public ResponseResult getAdvertise(){
        return  advertiseService.findAll();
    }
}
