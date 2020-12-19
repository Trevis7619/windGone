package com.trevis.mongo.service;

import com.trevis.mongo.entity.HistoryEntity;

import java.util.List;

/**
 *@author chenyijie
 *@Date  2020/12/19 6:30 下午
 */
public interface HistoryService {



    /**
     * 新增数据
     */
    void insert(HistoryEntity entity);


    /**
     * 显示数据
     */
    List<HistoryEntity> showAll();
}
