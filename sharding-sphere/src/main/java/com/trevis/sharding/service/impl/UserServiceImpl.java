package com.trevis.sharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trevis.sharding.entity.UserEntity;
import com.trevis.sharding.mapper.UserMapper;
import com.trevis.sharding.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements UserService {
}
