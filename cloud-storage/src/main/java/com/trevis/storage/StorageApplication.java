package com.trevis.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@author chenyijie
 *@Date  2020/9/12 8:27 上午
 *
 * 启动类添加扫描范围注解或者添加@Mapper
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }
}

