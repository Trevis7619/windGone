package com.trevis.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * es配置类
 * 将对象注入到spring
 */
@Configuration
public class ElasticSearchConfig {


    /**
     * 注入bean,实例化客户端对象
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {

        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                )
        );
    }
}
