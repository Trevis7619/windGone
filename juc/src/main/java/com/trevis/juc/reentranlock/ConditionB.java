package com.trevis.juc.reentranlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionB {


    Lock lock = new ReentrantLock();

    Condition c = lock.newCondition();

    boolean existA = true;


    public void a() throws InterruptedException {
        System.out.println("a尝试获取资源");
        lock.lock();
        try {
            if (existA) {
                c.await();
            }
            System.out.println("a");
            existA = true;
            c.signal();

        } finally {
            lock.unlock();
        }
    }


    public void b() throws InterruptedException {
        System.out.println("b尝试获取资源");
        lock.lock();
        try {
            if (!existA) {
                c.await();
            }
            System.out.println("b");
            existA = false;
            c.signal();
        } finally {
            lock.unlock();
        }
    }


}