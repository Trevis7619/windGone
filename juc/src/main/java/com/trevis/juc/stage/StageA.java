package com.trevis.juc.stage;

import com.trevis.juc.callable.CallableA;
import com.trevis.juc.callable.CallableB;
import com.trevis.juc.reentranlock.ConditionA;
import com.trevis.juc.reentranlock.ConditionB;
import com.trevis.juc.reentranlock.ConditionC;
import com.trevis.juc.reentranlock.SaleTicket;
import com.trevis.juc.service.CallService;
import com.trevis.juc.service.FucService;
import com.trevis.juc.service.Impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author chenyijie
 * @Date 2020/12/26 4:51 下午
 */
@RestController
@RequestMapping("stage")
public class StageA {

    @Autowired
    private BaseServiceImpl baseServiceImpl;


    /**
     * AsyncResult -> Future接口调用get()会阻塞线程
     */
    @GetMapping("minus")
    public void minus() throws InterruptedException {
        int total = 100;

        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(baseServiceImpl.minus(total));
        }

        for (Future<Integer> item : list) {
            while (true) {
                if (item.isDone()) {
                    break;
                }
            }
        }
    }


    /**
     * lamada表达式 ->函数式接口
     */
    @GetMapping("lambda")
    public void lambda() {

        //传统匿名内部类
        FucService fucService = new FucService() {
            //实现方法
            @Override
            public String say(String s) {
                return s + 1;
            }
        };
        System.out.println(fucService.say("123"));

        //lambda
        FucService fucService1 = (s) -> s;
        System.out.println(fucService1.say("13"));

        //{}代码返回快,只有一行省略{return ;}
        CallService callService = (a, b) -> 2 * a + b;
        System.out.println(callService.getInt(3, 4));


        //Thread入参Runnable接口对象直接使用lambda
        Thread x = new Thread(() -> {
        }, "a");
    }


    /**
     * list集合
     */
    @GetMapping("arrayList")
    public void arrayList() {
        //全局加锁
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());

        //写方法加可重入锁
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();


        //set
        CopyOnWriteArraySet<String> listSet1 = new CopyOnWriteArraySet<>();


        Set<String> s = new HashSet<>();

        Map<String, Object> zz = new HashMap<>();

        Map<String, Object> zxx = new ConcurrentHashMap<>();


    }


    /**
     * condition竞争同一个资源类
     * 若不满足条件,挂起线程释放锁切换线程
     */
    @GetMapping("threadTest")
    public void threadTest() {
        ConditionA conditiona = new ConditionA();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    conditiona.a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    conditiona.b();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @GetMapping("threadTest2")
    public void threadTest2() {
        ConditionB conditionB = new ConditionB();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    conditionB.a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    conditionB.b();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    /**
     * condition实现顺序执行线程
     */
    @GetMapping("threadTest3")
    public void threadTest3() {
        ConditionC conditionc = new ConditionC();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                conditionc.printA();
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                conditionc.printB();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                conditionc.printC();
            }
        }).start();
    }


    /**
     * futuretask是runnable,future的实现类
     */
    @GetMapping("futureTaskTest")
    public void futureTaskTest() throws ExecutionException, InterruptedException {
        //get()阻塞线程
        FutureTask<String> futureTask = new FutureTask<>(new CallableA());

        new Thread(futureTask).start();

        while (true) {
            if (futureTask.isDone()) {
                System.out.println(futureTask.get());
                break;
            }
        }

        //多线程实验
        FutureTask<String> a = new FutureTask<>(new CallableA());

        FutureTask<String> b = new FutureTask<>(new CallableB());


        new Thread(a).start();
        new Thread(b).start();
    }


    /**
     * reentrantock实现售票
     */
    @GetMapping("reentranlockTest")
    public void reentranlockTest() {
        SaleTicket saleTicket = new SaleTicket();

        synchronized (this) {
            System.out.println(this);
        }


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                saleTicket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                saleTicket.sale();
            }
        }, "B").start();
    }


    /**
     * countDownLatch计数类(闭锁)
     */
    @GetMapping("countDownLatchTest")
    public void countDownLatchTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("执行中");
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();
        System.out.println("结束");
    }
}
