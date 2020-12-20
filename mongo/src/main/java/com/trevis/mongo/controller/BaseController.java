package com.trevis.mongo.controller;

import com.trevis.mongo.entity.HistoryEntity;
import com.trevis.mongo.service.HistoryService;
import entity.Tr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenyijie
 * @Date 2020/12/19 6:27 下午
 */
@RestController
@RequestMapping(path = "history")
public class BaseController {

    @Autowired
    private HistoryService historyService;


    /**
     * 新增数据
     */
    @PostMapping("/doc")
    public void insert(@RequestBody HistoryEntity historyEntity) {
        historyService.insert(historyEntity);
    }


    /**
     * 查询所有数据
     */
    @GetMapping("/list")
    public Tr<?> showAll() {
        return new Tr<>(200, "请求成功", historyService.showAll());
    }

}
