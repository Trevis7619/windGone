package com.trevis.customer.controller;

import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenyijie
 * @Date 2020/10/2 2:53 下午
 * <p>
 * 公共controller
 */
public class AbstractController {

    /**
     * controller层参数校验
     */
    protected boolean inJudge(BindingResult result, Class<?> c) {
        if (result.hasErrors()) {
            List<String> errorList = result.getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            LoggerFactory.getLogger(c).error(new Gson().toJson(errorList));
            return false;
        }

        return true;
    }
}
