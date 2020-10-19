package com.trevis.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@author chenyijie
 *@Date  2020/9/12 8:27 上午
 *
 * 启动类添加扫描范围注解或者添加@Mapper
 * SEATA是基于数据源拦截来实现的分布式事务，因此，我们需要自定义数据源配置信息
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}

