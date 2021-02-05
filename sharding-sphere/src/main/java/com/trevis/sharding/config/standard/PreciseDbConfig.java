package com.trevis.sharding.config.standard;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 *@author chenyijie
 *@Date  2021/2/5 2:36 下午
 *
 * 标准分库算法
 */
@Component
@Slf4j
public class PreciseDbConfig implements PreciseShardingAlgorithm<Long> {


    /**
     * collection 库
     * 这里设置成永远分到wind_gone_2
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        log.info("standard分库,当前可用表:{}",new Gson().toJson(collection));
        Long id = preciseShardingValue.getValue();

        String rs = "wg2";

        return rs;
    }
}
