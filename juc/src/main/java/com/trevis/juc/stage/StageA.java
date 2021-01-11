package com.trevis.juc.stage;

import cn.hutool.core.thread.NamedThreadFactory;
import com.trevis.juc.callable.CallableA;
import com.trevis.juc.callable.CallableB;
import com.trevis.juc.readWriteLock.ReadWriteLockA;
import com.trevis.juc.reentranlock.ConditionA;
import com.trevis.juc.reentranlock.ConditionB;
import com.trevis.juc.reentranlock.ConditionC;
import com.trevis.juc.reentranlock.SaleTicket;
import com.trevis.juc.service.CallService;
import com.trevis.juc.service.FucService;
import com.trevis.juc.service.Impl.BaseServiceImpl;
import com.trevis.juc.volatileTest.VolatileA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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


    /**
     * volatile
     */
    @GetMapping("volatileTest")
    public void volatileTest() {
        VolatileA a = new VolatileA();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                a.start();
            }).start();
        }

        new Thread(() -> {
            a.stop();
        }).start();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                a.fakeStart();
            }).start();
        }

        new Thread(() -> {
            a.fakeStop();
        }).start();

    }


    /**
     * CyclicBarrier删栏,循环计数器
     */
    @GetMapping("cyclicBarrierTest")
    public void cyclicBarrierTest() {

        //三次计数后reset
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,
                new Thread(() -> {
                    System.out.println("我宣布阻塞暂时结束");
                }));


        for (int i = 0; i < 15; i++) {
            final int temp = i;
            new Thread(() -> {
                if (temp == 5) {
                    cyclicBarrier.reset();
                    System.out.println("逢5加班了");
                } else {
                    System.out.println("我被阻塞了");
                    try {
                        cyclicBarrier.await(2000, TimeUnit.MICROSECONDS);
                    } catch (InterruptedException | TimeoutException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }


    /**
     * Semaphore控制同时并发线程数,可以用于抢红包等
     */
    @GetMapping("semaphoreTest")
    public void semaphoreTest() {
        //维护一个3信号量的资源池
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    //信号量-1
                    semaphore.acquire();
                    System.out.println("抢到资源了,三秒后放出资源");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }

    }


    /**
     * readWriteLock读写锁
     * <p>
     * 写入时加锁
     * 读取时若没有线程在写入,允许并发读
     * <p>
     * 适用于读多写少的场景提高效率
     */
    @GetMapping("readWriteLockTest")
    public void readWriteLockTest() {

        ReadWriteLockA readWriteLockA = new ReadWriteLockA();

        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                try {
                    readWriteLockA.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                readWriteLockA.inc();
            }).start();
        }

    }


    /**
     * BlockingQueue阻塞队列
     */
    @GetMapping("bolckingQueueTest")
    public void blockingQueueTest() throws InterruptedException {

        //数组实现的阻塞队列
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        queue.put("1");
        queue.put("2");


        System.out.println(queue.poll());
        System.out.println(queue.take());
        // queue.stream().forEach(System.out::println);

        //链表实现的阻塞队列,可以不初始化大小
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<?> queue1 = new LinkedBlockingQueue<>(4);


        //双向列表,同时支持fifo,filo
        ConcurrentLinkedDeque<?> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        //concurrentLinkedDeque.addLast();

    }


    /**
     * ThreadPool 线程池
     */
    @GetMapping("ThreadPoolTest")
    public void threadPoolTest() throws ExecutionException, InterruptedException {

        //创建五个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //每个线程耗时五秒
        /*for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.println(finalI);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }*/

        //单例模式,线程池只有一个线程
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();


        ExecutorService executorService2 = Executors.newCachedThreadPool();


        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 2, TimeUnit.SECONDS
                , new ArrayBlockingQueue<Runnable>(5), new NamedThreadFactory("trevis", false)
                , new ThreadPoolExecutor.CallerRunsPolicy());


      /*  for(int i=0;i<10;i++){
            threadPoolExecutor.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }*/


        Future<String> d = threadPoolExecutor.submit(() -> "123");

        while (true) {
            if (d.isDone()) {
                System.out.println(d.get());
                break;
            }
        }
    }


    /**
     * stream流
     */
    @GetMapping("StreamTest")
    public void StreamTest() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list = list.stream().map(e -> e + "1").collect(Collectors.toList());
        System.out.println(list);
    }


    /**
     * CompletableFuture
     */
    @GetMapping("CompletableFutureTest")
    public void completableFutureTask() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //有返回值异步
        String a = "23";
        String result = CompletableFuture.supplyAsync(() -> {
            return a + "1";
        }).whenComplete((m, n) -> {
            System.out.println(m);
        }).get();


        //无返回值异步
        for (int i = 0; i < 10; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(123);
            }, executorService);
        }
    }
}
