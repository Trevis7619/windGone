package com.trevis.juc.callable;

import java.util.concurrent.Callable;

public class CallableA implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        System.out.println("callA");
        return "123";
    }
}
