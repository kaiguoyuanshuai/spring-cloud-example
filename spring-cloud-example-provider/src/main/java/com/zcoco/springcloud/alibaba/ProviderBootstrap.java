package com.zcoco.springcloud.alibaba;

import com.alibaba.druid.pool.DruidDataSource;
import com.zcoco.springcloud.alibaba.config.TestConfig;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */

@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableConfigurationProperties(TestConfig.class)
@ComponentScan(basePackages = "com.zcoco.springcloud")
public class ProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderBootstrap.class).run(args);
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DruidDataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }
}
