package com.trevis.mongo.service.impl;

import com.trevis.mongo.entity.HistoryEntity;
import com.trevis.mongo.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *@author chenyijie
 *@Date  2020/12/19 6:30 下午
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(@RequestBody HistoryEntity entity) {
        mongoTemplate.insert(entity);
    }
}
