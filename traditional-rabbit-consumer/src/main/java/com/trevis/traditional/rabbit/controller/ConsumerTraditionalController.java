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
    @RabbitListener(queues = "test.queue")
 /*   @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "ly.search.insert.queue", durable = "true"),
            exchange = @Exchange(name = "ly.item.exchange",
                    type = ExchangeTypes.TOPIC,
                    ignoreDeclarationExceptions = "true"),
            key = {"item.insert", "item.update"}
    ))*/
    public void watch(String message) {
        log.info("不使用stream驱动消费temp1消息:{}", new Gson().toJson(message));
        //ack尝试
       //int a = 0/0;
    }


}
