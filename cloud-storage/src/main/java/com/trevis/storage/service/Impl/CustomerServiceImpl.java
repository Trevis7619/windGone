package com.trevis.storage.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trevis.storage.dao.ComputerDao;
import com.trevis.storage.dto.ComputerDTO;
import com.trevis.storage.service.ComputerService;
import com.trevis.storage.entity.ComputerEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author chenyijie
 * @Date 2020/10/2 2:28 下午
 */
@Slf4j
@Service
public class CustomerServiceImpl extends ServiceImpl<ComputerDao, ComputerEntity> implements ComputerService {


    @Override
    public void reduceStorage(ComputerDTO dto) {
        //先查询是否有该商品,库存数量是否大于扣减商品数量
        int count = baseMapper.selectCount(new QueryWrapper<ComputerEntity>().eq("id", dto.getId())
                .ge("amount", dto.getAmount()));

        if (count <= 0) {
            log.error("库存不够或不存在此商品");
            return;
        }

        ComputerEntity entity = baseMapper.selectById(dto.getId());
        //库存扣减过后数量
        int newAmount = entity.getAmount() - dto.getAmount();

        ComputerEntity newEntity = new ComputerEntity();
        newEntity.setId(dto.getId());
        newEntity.setAmount(newAmount);
        baseMapper.updateById(newEntity);
        log.info("库存更新成功");
    }
}
