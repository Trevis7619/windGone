package com.trevis.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author chenyijie
 *@Date  2021/1/14 2:24 下午
 */
@RestController(value = "base")
public class BaseController {

    @GetMapping("hello")
    public String hello(){
        return "12";
    }

    @GetMapping("bye")
    public void bye(){
    }
}
