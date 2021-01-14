package com.trevis.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author chenyijie
 *@Date  2021/1/14 2:24 下午
 */
@RestController(value = "base")
public class BaseController {

    @GetMapping("vt")
    public void hello(){
        System.out.println("hello");
    }

    @GetMapping("bye")
    public void bye(){
        System.out.println("bye");
    }
}
