package com.trevis.traditional.rabbit.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author chenyijie
 * @Date 2020/11/5 10:09 上午
 */

/**
 * @author chenyijie
 * @Date 2020/11/5 10:09 上午
 */
@Slf4j
@Component
@EnableBinding(Sink.class)
public class ConsumerController {

    @Value("${server.port}")
    private String serverPort;


    //@StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者8802号,----->接受到的消息: " + message.getPayload() + "\t  port: " + serverPort);
    }


    /**
     * message支持泛型,也可以Message<String> message
     */
    //@StreamListener(Sink.INPUT)
    public void trevisInput(Message<Map<String, Object>> message) {
        log.info("消费者8802接受消息:{}", new Gson().toJson(message.getPayload()));
    }

}
