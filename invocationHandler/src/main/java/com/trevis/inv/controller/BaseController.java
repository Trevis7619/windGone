package com.trevis.inv.controller;

import com.trevis.inv.demo.DemoA;
import com.trevis.inv.entity.Trevis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inv")
public class BaseController {

    @Autowired
    private DemoA demoA;

    /**
     * 获取注解值
     */
    @GetMapping("init")
    public void init() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {


       Class<Trevis> c = Trevis.class;
       c.newInstance();

        System.out.println(1);
    }


    /**
     * 反射获取类机构
     */
    @GetMapping("class")
    public void classTest() throws NoSuchFieldException {
        System.out.println(Trevis.class.getDeclaredField("name"));
    }
}
