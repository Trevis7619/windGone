package com.trevis.juc.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;


@Service
public class BaseService  {

    @Async
    public Future<Integer> minus(int minus) throws InterruptedException {
        Thread.sleep(1000);
        return new AsyncResult<>(minus - 1);

    }

    @Async
    public void minus2() throws InterruptedException {
        Thread.sleep(500);
    }

}
