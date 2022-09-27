package com.crq.file.controller;

import com.crq.file.common.ResponseResult;
import com.crq.file.common.ResultCode;
import com.crq.file.util.MinIoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/27 20:24
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {
    @Resource
    private MinIoTemplate minIoTemplate;

    @PostMapping("/create/bucket")
    ResponseResult create(String bucketName) throws Exception {
        minIoTemplate.makeBucket(bucketName);
        return ResponseResult.success("创建成功");
    }

    @PostMapping("/upload")
    ResponseResult putObject(MultipartFile uploadFile, @RequestParam String bucketName) {
        String originalFilename = uploadFile.getOriginalFilename();
        try {
            minIoTemplate.putObject(bucketName, originalFilename, uploadFile.getInputStream());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseResult.failure(ResultCode.SYSTEM_INNER_ERROR,"创建失败");
        }
        return ResponseResult.success("http://139.196.153.80:9000/" + bucketName + "/" + originalFilename);
    }
}
