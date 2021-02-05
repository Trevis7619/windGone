package com.trevis.sharding.entity;

import com.baomidou.mybatisplus.annotation.*;
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
    //@TableField(value="version", fill = FieldFill.INSERT, update="%s+1")
    private Integer version;




}
