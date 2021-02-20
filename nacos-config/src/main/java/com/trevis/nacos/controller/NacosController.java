package com.trevis.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author chenyijie
 * @Date 2021/2/20 1:33 下午
 */
@RestController
@RefreshScope
public class NacosController {

    @Value("${trevis.hobby}")
    private String hobby;

    @Value("${trevis.name}")
    private String name;


    @GetMapping("nacos/hobby")
    public String getHobby() {
        System.out.println(hobby);
        System.out.println(name);
        return hobby;
    }
}
