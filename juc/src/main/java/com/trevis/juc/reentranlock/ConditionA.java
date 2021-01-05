package com.trevis.juc.reentranlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyijie
 * @Date 2021/1/4 8:39 下午
 * <p>
 * 同一个资源类两把锁
 * printA printB  交互打印
 *
 * 执行流程
 * 0.假设先执行a方法
 * 1.默认existA=true,将a方法所在线程放入等待队列a,释放锁
 * 2.执行b方法,打印b,修改exist=false,将等待队列a中的线程唤醒
 * 3.执行a方法,打印a,修改exist=true,将等待队列b中的线程唤醒
 * 4.线程争抢 循环
 *
 * 移步{@link ConditionC}
 */
public class ConditionA {


    Lock lock = new ReentrantLock();

    Condition a = lock.newCondition();
    Condition b = lock.newCondition();

    boolean existA = true;

    public void a() throws InterruptedException {
        System.out.println("a尝试获取资源");
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
        System.out.println("b尝试获取资源");
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
