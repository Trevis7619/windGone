package com.trevis.inv.demo;

import com.trevis.inv.annotation.FirstAnnotation;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 代理类代理say接口
 */
@FirstAnnotation(name = "haha")
@Component
@NoArgsConstructor
public class DaiLiA implements InvocationHandler {

    private Object target;

    /**
     * 构造函数传入代理对象
     */
    public DaiLiA(Object target) {
        this.target = target;
    }


    /**
     * 通过被代理类的类加载器,接口,委托给代理类
     *
     * @return Object 代理类
     */
    public Object bind() {
        Object o = target;
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始动态代理");
        return method.invoke(target, args);
    }
}
