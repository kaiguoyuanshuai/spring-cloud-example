package com.zcoco.springcloud.alibaba;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */
@Configuration
@ConfigurationProperties(prefix = "server")
public class TestConfig {
    private String port ;
    private String name;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
