package com.zcoco.springcloud.alibaba;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */

@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.zcoco.springcloud")
public class Bootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Bootstrap.class).run(args);
    }
}
