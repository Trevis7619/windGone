package com.trevis.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trevis.storage.dto.ComputerDTO;
import com.trevis.storage.entity.ComputerEntity;

/**
 *@author chenyijie
 *@Date  2020/10/2 2:34 下午
 */
public interface ComputerService extends IService<ComputerEntity> {

    /**
     * 用户使用积分兑换商品时,扣除库存
     *
     */
    void reduceStorage(ComputerDTO dto);

}
