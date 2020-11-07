package com.trevis.kafka.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *@author chenyijie
 *@Date  2020/11/6 9:06 上午
 *
 * kafka 输出通道bindings  连接到binder
 */
public interface KafkaOut {

    /**
     *@author chenyijie
     *@Date  2020/11/6 9:10 上午
     * 管道名称是kafka_out
     */
    @Output("kafka_out")
    MessageChannel kafka();
}
