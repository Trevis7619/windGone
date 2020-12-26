package com.trevis.juc.stage;

import com.trevis.juc.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
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
    public void minus() throws ExecutionException, InterruptedException {
        int total = 100;
        for (int i = 0; i < 100; i++) {
            System.out.println(1);
            Future<Integer> result = baseService.minus(total);
            total = result.get();
        }
    }
}
