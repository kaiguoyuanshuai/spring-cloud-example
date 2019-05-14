package com.zcoco.springcloud.alibaba.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */
@Configuration
@ConfigurationProperties(prefix = "test")
public class TestConfig {
    private boolean error;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}

