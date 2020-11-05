package com.trevis.customer.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 *@author chenyijie
 *@Date  2020/10/8 5:53 下午
 */
@Data
public class BuyDTO {
    /**
     * 用户id
     */
    @NotNull(message = "用户id不可为空")
    private Long userId;


    /**
     *购买的产品(computer)id
     */
    @NotNull(message = "产品id不可为空")
    private Long computerId;


    /**
     * 购买产品的单价
     */
    @NotNull(message = "产品单价不可为空")
    private Long price;

    /**
     * 购买的产品数量
     */
    @NotNull(message = "购买数量不可为空")
    private Long computerAmount;



}
