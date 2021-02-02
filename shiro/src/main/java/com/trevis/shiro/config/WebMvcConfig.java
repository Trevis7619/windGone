package com.trevis.shiro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chenyijie
 * @Date 2021/1/29 1:33 下午
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private loginInteceptor loginInteceptor;

    @Autowired
    private JwtInteceptor jwtInteceptor;


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


    /**
     * 拦截器拦截所有非登陆请求  拦截器不拦截登录页面,不拦截静态资源
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //mvc拦截器
     /*   registry.addInterceptor(loginInteceptor).excludePathPatterns("/login.html", "/statics/**"
        ,"/shiro/login");*/

        //token
        registry.addInterceptor(jwtInteceptor).excludePathPatterns("/login.html", "/statics/**"
                ,"/shiro/login");

    }
}
