package com.trevis.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_user")
public class UserEntity implements Serializable {

    @TableId
    private Long id;


    private String name;

    private String password;

    @TableLogic
    private boolean deleted;

    @Version
    private int version;




}
