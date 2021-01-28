package com.trevis.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserEntity {

    @TableId
    private Long id;


    private String name;

    private String password;

    private boolean deleted;


}
