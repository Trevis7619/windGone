package com.trevis.sharding.controller;

import com.trevis.sharding.entity.UserEntity;
import com.trevis.sharding.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@author chenyijie
 *@Date  2021/2/4 1:26 下午
 */
@RestController
public class ShardingController {

    @Resource
    private UserService userService;


    /**
     * 新增
     */
    @GetMapping("/sd/insert")
    public void insert(String name){
        UserEntity userEntity = new UserEntity();

        userEntity.setName(name);

        userService.save(userEntity);
    }
}
