package com.trevis.juc.reentranlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyijie
 * @Date 2021/1/5 11:14 上午
 * <p>
 * 售票资源类
 */
public class SaleTicket {

    Lock lock = new ReentrantLock();

    /**
     * 总票数
     */
    private int total = 100;

    /**
     * 售票机器
     */
    public void sale() {
        lock.lock();
        try {
            if (total > 0) {
                total = total - 1;
                System.out.println("剩余票数:" + total);
            }
        } finally {
            lock.unlock();
        }
    }
}
