package com.trevis.shiro.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenyijie
 * @Date 2021/1/29 3:37 下午
 * <p>
 * 登陆拦截器
 */
@Component
@Slf4j
public class loginInteceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getSession().getAttribute("username") != null) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/login.html");
        return false;
    }
}
