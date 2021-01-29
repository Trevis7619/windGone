package com.trevis.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trevis.shiro.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *@author chenyijie
 *@Date  2021/1/28 10:21 下午
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
