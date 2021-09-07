package com.trevis.marriage.entity;

import lombok.Data;

/**
 *@author chenyijie
 *@Date  2021/9/8 12:37 上午
 */
@Data
public class InitEntity {

    private int Id;

    private String name;

    private String sex;

    private String age;

    private String shenXiao;

    private String height;

    private String weight;

    private String academic;

    private String hourceAndCar;

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
