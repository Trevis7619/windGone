package com.trevis.marriage.controller;

import com.trevis.marriage.service.InitService;
import entity.Tr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author chenyijie
 *@Date  2021/9/7 11:54 下午
 */
@Slf4j
@RestController
@RequestMapping("/marriage")
public class InitController {

    @Autowired
    private InitService initService;


    @GetMapping("/list")
    public Tr<?> list(){
        return new Tr<>(200,"",initService.getList());
    }




}
