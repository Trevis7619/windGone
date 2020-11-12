package com.trevis.rabbit.controller;

import com.trevis.rabbit.service.IMessageProvider;
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


    @GetMapping("/rabbit/provider/port")
    public void getPort() {
        iMessageProvider.trevisSend();
    }

}
