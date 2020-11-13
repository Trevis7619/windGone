package com.trevis.rabbit.controller;

import com.trevis.rabbit.service.IMessageProvider;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyijie
 * @Date 2020/11/5 10:09 上午
 */
@RestController
public class ProducerController {

    @Resource
    private IMessageProvider iMessageProvider;

    /**
     * 不使用消息驱动
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/rabbit/provider/port")
    public void getPort() {
        iMessageProvider.trevisSend();
    }


    @GetMapping("/rabbit/test1")
    public void test1(){
        //发送消息
       rabbitTemplate.convertAndSend("studyExchange","","不使用消息驱动发送消息");
       //同步消费者,消费者接收到后才会发送下一条
       //rabbitTemplate.convertSendAndReceive("studyExchange","","不使用消息驱动发送同步消息");
    }

}
