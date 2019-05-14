package com.zcoco.springcloud.alibaba.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: heshouyou
 * @Description  fescar global configuration
 * @Date Created in 2019/1/24 10:28
 */
@Configuration
public class SeataConfig {

    /**
     * init global transaction scanner
     *
     * @Return: GlobalTransactionScanner
     */
/*    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("service-consumer", "my_test_tx_group");
    }*/
}
