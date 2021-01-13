package com.trevis.inv.controller;

import com.trevis.inv.annotation.FirstAnnotation;
import com.trevis.inv.demo.DemoA;
import com.trevis.inv.entity.Trevis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
@RequestMapping("inv")
public class BaseController {

    @Autowired
    private DemoA demoA;

    /**
     * 反射操作方法
     */
    @GetMapping("init")
    public void init() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //获取类对象
        Class<Trevis> c = Trevis.class;
        //通过反射获取类实例
        Trevis t = c.newInstance();
        //获取类的setName方法
        Method setName = c.getDeclaredMethod("setName", String.class);
        //invoke()激活方法
        setName.invoke(t, "通过反射修改陈艺杰的名字");

        System.out.println(t.getName());

    }


    /**
     * 反射操作属性
     */
    @GetMapping("field")
    public void fieldTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Trevis> c = Trevis.class;
        //获取类的实例
        Trevis t = c.newInstance();
        //获取类的属性
        Field field = c.getDeclaredField("name");
        //修改私有属性之前打开访问权限
        field.setAccessible(true);
        //修改实例对应属性的值
        field.set(t, "通过反射修改实例属性的值");
        System.out.println(t.getName());
    }


    /**
     * 反射获取注解值
     */
    @GetMapping("annotationTest")
    public void annotationTest() {
        //获取实例
       Trevis t = new Trevis();
       //通过实例反射获取类
        Class<?> trevisClass = t.getClass();


        Annotation[] annotations = trevisClass.getAnnotations();
        for(Annotation item: annotations){
           if(item.annotationType()==FirstAnnotation.class){
               System.out.println("匹配到了");
           }
        }

        //判断是否存在当前注解
        boolean result = trevisClass.isAnnotationPresent(FirstAnnotation.class);
        if(result){
            FirstAnnotation annotation = trevisClass.getAnnotation(FirstAnnotation.class);
            System.out.println(annotation.hobby());
        }

    }

}
