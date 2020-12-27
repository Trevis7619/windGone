package com.trevis.juc.service;

/**
 * @author chenyijie
 * @Date 2020/12/27 5:47 下午
 * 函数式接口
 */
@FunctionalInterface
public interface FucService {

    /**
     * 函数式编程只能有一个抽象方法
     */
    public String say(String s);


    /**
     * 接口default方法
     */
    public default String getS() {
        return "swd";
    }

    public static int A = 1;

    public static int B = 1;
}
