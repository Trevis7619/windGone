package com.trevis.juc.readWriteLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenyijie
 * @Date 2021/1/7 8:36 上午
 */
public class ReadWriteLockA {

    ReadWriteLock lock = new ReentrantReadWriteLock();

    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    private int a = 10;

    public void inc() {
        writeLock.lock();
        try {
            System.out.println("多线程同时写,线程睡眠5秒");
            TimeUnit.SECONDS.sleep(5);
            a = a + 1;
            System.out.println(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void read() throws InterruptedException {
        readLock.lock();
        try {
            System.out.println(a);
        } finally {
            readLock.unlock();
        }
    }
}
