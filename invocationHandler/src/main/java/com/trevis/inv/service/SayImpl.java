package com.trevis.inv.service;

import org.springframework.stereotype.Service;

/**
 *@author chenyijie
 *@Date  2021/1/13 5:07 下午
 *
 * sayHello接口实现类
 */
@Service
public class SayImpl implements Say {
    @Override
    public void sayHello() {
        System.out.println("hello KuGou");
    }
}
