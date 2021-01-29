package com.trevis.shiro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.trevis.shiro.entity.UserEntity;
import com.trevis.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("shiro")
@RestController
@Slf4j
public class BaseController {

    @Autowired
    private UserService userService;



    @GetMapping("init")
    public String init(HttpSession httpSession) {
        log.info("测试:{}", new Gson().toJson(httpSession));
        UserEntity userEntity = userService.getOne(
                new QueryWrapper<UserEntity>().eq("name", "cyj")
        );
        return userEntity.getPassword();
    }
}
