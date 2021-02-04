package com.trevis.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trevis.sharding.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *@author chenyijie
 *@Date  2021/1/28 10:21 下午
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
}
