package com.trevis.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_role")
public class SysRoleEntity implements Serializable {

    @TableId
    private Long id;


    private String roleName;

    @TableLogic
    private boolean deleted;


}