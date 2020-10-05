package com.trevis.customer.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trevis.customer.dao.CustomerDao;
import com.trevis.customer.entity.CustomerEntity;
import com.trevis.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author chenyijie
 * @Date 2020/10/2 2:28 下午
 */
@Slf4j
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {

    @Override
    public void getNewCustomer(CustomerEntity entity) {
        int count = baseMapper.selectCount(new QueryWrapper<CustomerEntity>().eq("name",entity.getName()));
        switch (count){
            case 0:
                baseMapper.insert(entity);
                break;
            default:
                log.error("保存失败");
        }

    }
}
