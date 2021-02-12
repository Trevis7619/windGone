package com.trevis.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenyijie
 * @Date 2021/2/4 8:42 上午
 */
@MapperScan("com.trevis.sharding.mapper")
@SpringBootApplication
public class ShardingApplication {

    public static void main(String[] args) {
        ThreadLocal<String> x = new ThreadLocal<>();
        x.set("132");
        System.out.println(x.get());
        SpringApplication.run(ShardingApplication.class, args);
    }
}
