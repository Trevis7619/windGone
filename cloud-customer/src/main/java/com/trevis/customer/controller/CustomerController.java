package com.trevis.customer.controller;

import com.trevis.customer.dto.BuyDTO;
import com.trevis.customer.dto.ComputerDTO;
import com.trevis.customer.entity.CustomerEntity;
import com.trevis.customer.service.CustomerService;
import com.trevis.customer.service.FeignCustomerService;
import entity.Tr;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author chenyijie
 * @Date 2020/9/12 8:33 上午
 * <p>
 * 消费者controller
 */
@Slf4j
@RestController
public class CustomerController extends AbstractController {

    @Autowired
    private CustomerService customerService;


    /**
     * 仓储feign接口
     */
    @Autowired
    private FeignCustomerService feignCustomerService;

    /**
     * 新增顾客
     */
    @PostMapping("/customer/new")
    public Tr<?> getNewCustomer(@RequestBody @Valid CustomerEntity entity, BindingResult result) {
        log.info("新增顾客");
        //入参验证
        if (!inJudge(result, getClass())) {
            return new Tr<>(404, "参数有误");
        }
        customerService.getNewCustomer(entity);
        return new Tr<>(200, "正确", entity);
    }


    /**
     * 顾客使用积分兑换电脑
     * step1:扣减积分
     * step2:扣减库存
     */
    @GlobalTransactional
    @PatchMapping("/customer/buy")
    public Tr<?> buyPc(@RequestBody @Valid BuyDTO dto, BindingResult result) {
        log.info("顾客使用积分兑换电脑");
        //入参验证
        if (!inJudge(result, getClass())) {
            return new Tr<>(404, "参数有误");
        }

        //扣减积分
        boolean isReducePoints = customerService.reducePoints(dto);


        //扣减库存
        ComputerDTO computerDTO = ComputerDTO.builder()
                .id(dto.getUserId())
                .amount(dto.getComputerAmount())
                .build();
        feignCustomerService.changeStorage(computerDTO);

        return new Tr<>(200, "成功");
    }
}
