package com.trevis.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trevis.customer.entity.CustomerEntity;

/**
 *@author chenyijie
 *@Date  2020/10/2 2:34 下午
 */
public interface CustomerService extends IService<CustomerEntity> {


    /**
     * 新增用户
     * @param entity e
     */
    void getNewCustomer(CustomerEntity entity);

}
