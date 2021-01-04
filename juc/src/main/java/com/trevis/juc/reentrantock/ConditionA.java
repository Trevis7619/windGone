package com.trevis.juc.reentrantock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyijie
 * @Date 2021/1/4 8:39 下午
 * <p>
 * 同一个资源类两把锁
 * printA printB  交互打印
 */
public class ConditionA {


    Lock lock = new ReentrantLock();

    Condition a = lock.newCondition();
    Condition b = lock.newCondition();

    boolean existA = true;


    public void a() throws InterruptedException {
        lock.lock();
        try {
            if (existA) {
                a.await();
            }
            System.out.println("a");
            existA = true;
            b.signal();

        } finally {
            lock.unlock();
        }
    }


    public void b() throws InterruptedException {
        lock.lock();
        try {
            if (!existA) {
                b.await();
            }
            System.out.println("b");
            existA = false;
            a.signal();
        } finally {
            lock.unlock();
        }
    }


}
