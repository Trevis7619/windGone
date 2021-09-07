package com.trevis.marriage.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trevis.marriage.entity.InitEntity;
import com.trevis.marriage.mapper.InitMapper;
import com.trevis.marriage.service.InitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl extends ServiceImpl<InitMapper, InitEntity> implements InitService {


    /**
     * get list
     */
    @Override
    public List<InitEntity> getList(){
        return baseMapper.selectList(new QueryWrapper<>());
    }
}
