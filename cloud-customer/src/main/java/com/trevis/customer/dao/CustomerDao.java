package com.trevis.customer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trevis.customer.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chenyijie
 * @Date 2020/10/2 2:29 下午
 * <p>
 * 连接数据库
 * 继承BaseMapper
 */
@Mapper
public interface CustomerDao extends BaseMapper<CustomerEntity> {
}
