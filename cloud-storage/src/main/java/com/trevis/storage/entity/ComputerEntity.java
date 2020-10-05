package com.trevis.storage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("computer")
public class ComputerEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String brand;

    private Long price;

    private int amount;
}
