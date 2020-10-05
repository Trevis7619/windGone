package com.trevis.storage.controller;

import com.trevis.storage.dto.ComputerDTO;
import com.trevis.storage.service.ComputerService;
import entity.Tr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyijie
 * @Date 2020/10/5 4:13 下午
 * <p>
 * pc购买controller
 */
@RestController
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    /**
     * 更新库存
     * todo  此处应该加锁
     * todo  全局事务
     */
    @PatchMapping("/amount")
    public Tr<?> changeStorage(@RequestBody ComputerDTO computerDTO) {
        computerService.reduceStorage(computerDTO);
        return new Tr<>(200,"更新成功");
    }


}
