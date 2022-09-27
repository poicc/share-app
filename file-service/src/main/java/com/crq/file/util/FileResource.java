package com.crq.file.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/27 20:32
 */
@Data
@Component
@ConfigurationProperties(prefix = "file")
@PropertySource(value = {"classpath:file.properties"})
public class FileResource {
    private String endPoint;
    private String accessKey;
    private String secretKey;
}
