package com.ovp.properties;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "eovp.alioss")
public class AliOssProperties {
    private String endpoint;
    private String bucketName;
    private String region;
}
