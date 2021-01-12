package com.trevis.inv.demo;

import com.trevis.inv.annotation.FirstAnnotation;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@FirstAnnotation(name="haha")
@Component
public class DemoA implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class.forName("123");

        return null;
    }
}
