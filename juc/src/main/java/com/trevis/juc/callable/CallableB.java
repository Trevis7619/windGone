package com.trevis.juc.callable;

import java.util.concurrent.Callable;

public class CallableB implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        System.out.println("callB");
        return "321";
    }
}