package com.trevis.juc.volatileTest;

public class VolatileA {
    volatile boolean stopped = false;

    boolean fakeStopped = false;


    public void stop() {
        stopped = true;
        System.out.println("关闭");
    }

    public void start()  {

        if (!stopped) {
            System.out.println("狂欢");
        }
    }

    public void fakeStop() {
        fakeStopped = true;
        System.out.println("虚假的关闭");
    }

    public void fakeStart() {
        if (!fakeStopped) {
            System.out.println("狂欢任在继续");
        }
    }
}
