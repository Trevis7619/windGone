package com.trevis.kafka.service.impl;

import com.trevis.kafka.config.KafkaOut;
import com.trevis.kafka.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyijie
 * @Date 2020/11/5 10:10 上午
 */
@Slf4j
@EnableBinding(KafkaOut.class) //定义消息的推送管道类型(生产者)
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
  /*  @Autowired
    private MessageChannel output;*/

    @Autowired
    private KafkaOut kafkaOut;


    @Value("${server.port}")
    private String port;



    @Override
    public void trevisSend() {
        log.info("生产者开始向消息中间件发送消息");
        Map<String, Object> result = new HashMap<>();
        result.put("port", port);
        kafkaOut.kafka().send(MessageBuilder.withPayload(result).build());
    }





}
