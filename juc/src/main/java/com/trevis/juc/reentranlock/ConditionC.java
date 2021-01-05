package com.trevis.juc.reentranlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyijie
 * @Date 2021/1/5 2:18 下午
 * <p>
 * condition多条件资源类竞争实例
 * <p>
 * 循环打印a,b,c
 */
public class ConditionC {

    /**
     * a,b,c;flag为什么就执行当前print方法
     */
    private String flag = "a";

    Lock lock = new ReentrantLock();

    /**
     * 确保每个线程每次都会执行print操作,所以需要三个等待队列
     */
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC =  lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (!"a".equals(flag)) {
                conditionA.await();
            }

            System.out.println(flag);
            flag = "b";
            conditionB.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {

        lock.lock();
        try {
            while (!"b".equals(flag)) {
                conditionB.await();
            }

            System.out.println(flag);
            flag = "c";
            conditionC.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {

        lock.lock();
        try {
            while (!"c".equals(flag)) {
                conditionC.await();
            }

            System.out.println(flag);
            flag = "a";
            conditionA.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
