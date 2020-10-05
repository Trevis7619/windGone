package com.trevis.storage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trevis.storage.entity.ComputerEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComputerDao extends BaseMapper<ComputerEntity> {
}
