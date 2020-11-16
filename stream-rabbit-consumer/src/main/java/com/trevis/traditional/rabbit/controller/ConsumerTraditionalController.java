package com.trevis.traditional.rabbit.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author chenyijie
 * @Date 2020/11/13 1:52 下午
 */
@Slf4j
@Component
public class ConsumerTraditionalController {

    /**
     * 监听消费消息
     * 监听队列,消费temp1队列
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "studyExchange", type = "topic"),
            value = @Queue(value = "studyExchange.port9801Queue")))
    public void watch(String message) {
        log.info("不使用stream驱动消费temp1消息:{}", new Gson().toJson(message));
    }


}
