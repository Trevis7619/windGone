package com.trevis.shiro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *@author chenyijie
 *@Date  2021/1/29 1:33 下午
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 访问静态资源
     * 表示 请求路径为/statics/**的,会去classpath:/statics/查找资源;
     * demo: http://localhost:1234/statics/js/vue.js
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**")
                .addResourceLocations("classpath:/statics/");

        registry.addResourceHandler("/*.html")
                .addResourceLocations("classpath:/templates/");
    }
}
