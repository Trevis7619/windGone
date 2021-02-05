package com.trevis.sharding.controller;

import com.trevis.sharding.entity.SysRoleEntity;
import com.trevis.sharding.entity.UserEntity;
import com.trevis.sharding.service.SysRoleService;
import com.trevis.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyijie
 * @Date 2021/2/4 1:26 下午
 */
@RestController
public class ShardingController {

    @Resource
    private UserService userService;

    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 新增
     */
    @GetMapping("/sd/insert")
    public void insert(String name) {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(name);

        userService.save(userEntity);

        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        sysRoleEntity.setRoleName("ky");
        sysRoleService.save(sysRoleEntity);
    }




    /**
     * 修改,根据主键修改
     */
    @GetMapping("/sd/changeById")
    public void change(Long id) {
        UserEntity userEntity = userService.getById(id);
        userEntity.setPassword("1234");
        userService.updateById(userEntity);
    }
}
