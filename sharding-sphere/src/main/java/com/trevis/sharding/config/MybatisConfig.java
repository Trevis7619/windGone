package com.trevis.sharding.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@author chenyijie
 *@Date  2021/2/5 10:52 上午
 */
@Configuration
public class MybatisConfig {

    /**
     * 注册乐观锁插件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return  new OptimisticLockerInterceptor();
    }
}
