package com.trevis.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@author chenyijie
 *@Date  2020/9/12 8:27 上午
 *
 * 启动类添加扫描范围注解或者添加@Mapper
 */
@SpringBootApplication
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }
}

