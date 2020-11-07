package com.trevis.kafka.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @author chenyijie
 * @Date 2020/11/6 9:13 上午
 */
public interface KafkaIn {

    @Input("kafka_in")
    MessageChannel kafka();


}
