package com.trevis.customer.controller;

import com.trevis.customer.entity.CustomerEntity;
import com.trevis.customer.service.CustomerService;
import entity.Tr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
     * 新增顾客
     */
    @PostMapping("customer/new")
    public Tr<?> getNewCustomer(@RequestBody @Valid CustomerEntity entity, BindingResult result) {
        log.info("新增顾客");
        //入参验证
        if (!inJudge(result, getClass())) {
            return new Tr<>(404, "参数有误");
        }
        customerService.getNewCustomer(entity);
        return new Tr<>(200, "正确", entity);
    }
}
