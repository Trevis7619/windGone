package com.trevis.traditional.rabbit.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyijie
 * @Date 2020/11/5 10:09 上午
 */
@RestController
public class ProducerController {

    /**
     * 不使用消息驱动
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/rabbit/test1")
    public void test1(){
        //发送消息 发送到指定交换机的指定路由方式的队列中
       rabbitTemplate.convertAndSend("trevis.topicEx","#","不使用stream发送消息");
       //同步消费者,消费者接收到后才会发送下一条
       //rabbitTemplate.convertSendAndReceive("studyExchange","","不使用消息驱动发送同步消息");
    }

}
