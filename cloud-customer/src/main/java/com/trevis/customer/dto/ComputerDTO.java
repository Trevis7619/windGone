package com.trevis.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@author chenyijie
 *@Date  2020/10/5 4:38 下午
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDTO {

    private Long id;

    private  Long amount;
}
