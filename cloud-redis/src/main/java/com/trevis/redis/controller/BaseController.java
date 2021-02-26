package com.trevis.redis.controller;

import com.google.gson.Gson;
import com.trevis.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("redis")
public class BaseController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @GetMapping("test")
    public void z() throws InterruptedException {
        System.out.println(Thread.currentThread());
        String a ="1";
        TimeUnit.SECONDS.sleep(100);
    }


    @GetMapping("init")
    public void init() {
        //redis实现分布式锁
        redisTemplate.opsForValue().setIfAbsent("lock","id",10,TimeUnit.SECONDS);

        redisTemplate.opsForValue().set("name", "陈艺杰");
        redisTemplate.opsForValue().set("name", "cyj", 200, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("name"));

        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        redisTemplate.opsForList().leftPushAll("list1",list);

        redisTemplate.multi();


    }


    /**
     * redis事务
     */
    @GetMapping("multi")
    public void multi(){
        redisTemplate.opsForValue().set("name",2);
        redisTemplate.opsForValue().increment("name",3);
        System.out.println(redisTemplate.opsForValue().get("name"));
    }


    /**
     * 序列化,对象使用json存储
     */
    @GetMapping("seri")
    public void seri(){
        User user = new User();
        user.setName("陈艺杰");
        user.setHobby("游泳");

        //存json
        redisTemplate.opsForValue().set("minDan",new Gson().toJson(user));
        User user1 = new Gson().fromJson((String) redisTemplate.opsForValue().get("minDan"),User.class);
        System.out.println(user1.getName());
        System.out.println(user1.getHobby());


        //存entity json
        redisTemplate.opsForValue().set("minDan2",user);
        User user2 = (User) redisTemplate.opsForValue().get("minDan2");
        System.out.println(user2.getName());
        System.out.println(user2.getHobby());

    }

}
