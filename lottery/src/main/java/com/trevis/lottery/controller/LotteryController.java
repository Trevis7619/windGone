package com.trevis.lottery.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author chenyijie
 *@Date  2020/9/12 8:33 上午
 */
@Slf4j
@RestController
public class LotteryController {

    @GetMapping("a")
    public String A(){
        return "asd";
    }
}
