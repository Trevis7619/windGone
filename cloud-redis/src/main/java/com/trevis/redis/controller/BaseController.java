package com.trevis.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("redis")
public class BaseController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;




    @GetMapping("init")
    public void init() {
        redisTemplate.opsForValue().set("name", "陈艺杰");
        redisTemplate.opsForValue().set("name", "cyj", 200, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("name"));

        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        redisTemplate.opsForList().leftPushAll("list1",list);
        List<Object> returns =  redisTemplate.opsForList().range("list1",0,-1);

    }

}
