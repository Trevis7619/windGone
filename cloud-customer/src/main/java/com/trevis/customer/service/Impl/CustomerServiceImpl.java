package com.trevis.customer.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trevis.customer.dao.CustomerDao;
import com.trevis.customer.entity.CustomerEntity;
import com.trevis.customer.service.CustomerService;
import org.springframework.stereotype.Service;


/**
 * @author chenyijie
 * @Date 2020/10/2 2:28 下午
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {

    @Override
    public void getNewCustomer(CustomerEntity entity) {
        baseMapper.insert(entity);
    }
}
