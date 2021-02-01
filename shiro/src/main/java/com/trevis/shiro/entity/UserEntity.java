package com.trevis.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_user")
public class UserEntity implements Serializable {

    @TableId
    private Long id;


    private String name;

    private String password;

    private boolean deleted;


}
