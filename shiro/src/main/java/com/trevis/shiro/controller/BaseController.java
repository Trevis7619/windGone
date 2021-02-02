package com.trevis.shiro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.trevis.shiro.entity.UserEntity;
import com.trevis.shiro.service.UserService;
import com.trevis.shiro.util.JwtUtil;
import entity.Tr;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("shiro")
@RestController
@Slf4j
public class BaseController {

    @Autowired
    private UserService userService;


    /**
     * 拦截器登录
     */
    //@PostMapping("login")
    public Tr<?> login(HttpSession httpSession, @RequestBody UserEntity entity) {
        log.info("测试:{}", new Gson().toJson(httpSession));
        log.info("登陆:{}", new Gson().toJson(entity));
        //尝试登陆
        int count = userService.count(
                new QueryWrapper<UserEntity>()
                        .eq("name", entity.getName())
                        .eq("password", entity.getPassword())
        );

        if (count == 1) {
            httpSession.setAttribute("username", "cyj");
            return new Tr<>(200, "登陆成功");
        }
        return new Tr<>("登录失败");
    }


    //@PostMapping("login")
    public Tr<?> shiroLogin(HttpSession httpSession,@RequestBody UserEntity entity) {
        log.info("session:{}", new Gson().toJson(httpSession));

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken(entity.getName(), entity.getPassword()));

            //将登陆信息存储到redis
            return new Tr<>(200, "登陆成功");

        } catch (Exception e) {
            return new Tr<>("登录失败");
        }
    }


    /**
     * 验证登录成功之后生成token
     */
    @PostMapping("login")
    public Tr<?> jwtLogin(HttpSession httpSession,@RequestBody UserEntity entity) {
        log.info("session:{}", new Gson().toJson(httpSession));

        UserEntity userEntity = userService.getOne(
                new QueryWrapper<UserEntity>()
                        .eq("name", entity.getName()));


        if(userEntity==null){
            return new Tr<>("账号不存在");
        }
        if(!entity.getPassword().equals(userEntity.getPassword())){
            return new Tr<>("密码错误");
        }

        //如果账号密码正确,生成token
        String jwtToken = JwtUtil.sign(entity.getName());
        log.info("获取token:{}",new Gson().toJson(jwtToken));

        return new Tr<>(200, jwtToken,"登陆成功");
    }




    @GetMapping("age")
    public Tr<?> getAge() {
        return new Tr<>(200, "请求成功", 20);
    }

}
