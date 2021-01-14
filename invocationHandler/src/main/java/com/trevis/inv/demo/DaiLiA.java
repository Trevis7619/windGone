package com.trevis.inv.demo;

import com.trevis.inv.annotation.FirstAnnotation;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 代理类代理say接口
 */
@FirstAnnotation(name = "haha")
@Component
@NoArgsConstructor
public class DaiLiA implements InvocationHandler {


    /**
     * 被代理对象
     */
    private Object target;

    /**
     * 构造函数传入代理对象
     */
    public DaiLiA(Object target) {
        this.target = target;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始动态代理");
        return method.invoke(target, args);
    }
}
