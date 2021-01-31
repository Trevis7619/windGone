package com.trevis.shiro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.trevis.shiro.entity.UserEntity;
import com.trevis.shiro.service.UserService;
import entity.Tr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("shiro")
@RestController
@Slf4j
public class BaseController {

    @Autowired
    private UserService userService;



    @PostMapping("login")
    public Tr<?> login(HttpSession httpSession, @RequestBody UserEntity entity) {
        log.info("测试:{}", new Gson().toJson(httpSession));
        log.info("登陆:{}",new Gson().toJson(entity));
        //尝试登陆
       int count = userService.count(
         new QueryWrapper<UserEntity>()
         .eq("name",entity.getName())
         .eq("password",entity.getPassword())
       );

       if(count==1){
           httpSession.setAttribute("username","cyj");
           return new Tr<>(200,"登陆成功");
       }
       return new Tr<>("登录失败");
    }

    @GetMapping("age")
    public Tr<?> getAge(){
        return new Tr<>(200,"请求成功",20);
    }

}
