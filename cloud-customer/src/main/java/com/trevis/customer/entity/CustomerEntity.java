package com.trevis.customer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author chenyijie
 * @Date 2020/10/2 2:40 下午
 */
@Data
@TableName("user")
public class CustomerEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "姓名不可为空")
    private String name;

    private Long ownedMoney;

}
