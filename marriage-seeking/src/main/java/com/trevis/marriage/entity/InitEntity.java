package com.trevis.marriage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *@author chenyijie
 *@Date  2021/9/8 12:37 上午
 */
@Data
@TableName("result")
public class InitEntity {

    @TableId(type = IdType.AUTO)
    private int id;

    private String name;

    private String sex;

    private String age;

    private String shenXiao;

    private String height;

    private String weight;

    private String academic;

    private String houseCar;

    private String work;

    private String money;

    /**
     * 籍贯
     */
    private String birthPlace;

    /**
     * 现居地
     */
    private String nowPlace;

    /**
     * 期望位置
     */
    private String expectPlace;



}
