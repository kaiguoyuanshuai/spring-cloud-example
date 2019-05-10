package com.zcoco.springcloud.alibaba;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.alibaba.dubbo.annotation.DubboTransported;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableFeignClients //让 FeignClient 生效
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.zcoco.springcloud")
public class ConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootstrap.class);
    }


    @Bean
    @LoadBalanced
    //添加Dubbo实现的时候需要添加的注解
    @DubboTransported
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
