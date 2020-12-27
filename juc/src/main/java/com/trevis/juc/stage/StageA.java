package com.trevis.juc.stage;

import com.trevis.juc.service.FucService;
import com.trevis.juc.service.Impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author chenyijie
 * @Date 2020/12/26 4:51 下午
 */
@RestController
@RequestMapping("stage")
public class StageA {

    @Autowired
    private BaseService baseService;


    /**
     * AsyncResult -> Future接口调用get()会阻塞线程
     */
    @GetMapping("minus")
    public void minus() throws InterruptedException {
        int total = 100;

        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(baseService.minus(total));
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
    public void lambda(){
        //传统匿名内部类
        FucService fucService = new FucService() {
            @Override
            public String say(String s) {
                return s+1;
            }
        };
        System.out.println(fucService.say("123"));

        //lambda
        FucService fucService1 = (s)->s;
        System.out.println(fucService1.say("13"));




    }

}
