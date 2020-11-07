package com.trevis.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author chenyijie
 * @Date 2020/11/5 9:54 上午
 * 入口类
 */
@SpringBootApplication
public class KafkaConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerMain.class, args);
    }
}