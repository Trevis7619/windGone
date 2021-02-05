package com.trevis.sharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trevis.sharding.entity.SysRoleEntity;
import com.trevis.sharding.mapper.SysRoleMapper;
import com.trevis.sharding.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServieImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {
}
