package com.trevis.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trevis.shiro.entity.UserEntity;
import com.trevis.shiro.mapper.UserMapper;
import com.trevis.shiro.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements UserService {
}
