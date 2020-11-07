package com.trevis.kafka.controller;

import com.trevis.kafka.service.IMessageProvider;
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


    @GetMapping("/kafka/provider/port")
    public void getPort() {
        iMessageProvider.trevisSend();
    }

}
