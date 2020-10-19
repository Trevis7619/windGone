package com.trevis.customer.service;

import com.trevis.customer.dto.ComputerDTO;
import entity.Tr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *@author chenyijie
 *@Date  2020/10/8 6:24 下午
 *
 * feign接口
 */
@FeignClient(value = "cloud-storage")
public interface FeignCustomerService {

    /**
     * 调用仓储微服务扣减库存接口
     */
    @PatchMapping("/amount")
    Tr<?> changeStorage(@RequestBody ComputerDTO computerDTO);
}
