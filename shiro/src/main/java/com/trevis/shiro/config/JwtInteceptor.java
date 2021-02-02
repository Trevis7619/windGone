package com.trevis.shiro.config;

import com.trevis.shiro.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class JwtInteceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        log.info("获取token:{}",token);


        if(StringUtils.isNotBlank(JwtUtil.verify(token))){
            return true;
        }

        response.sendRedirect(request.getContextPath() + "/login.html");
        return false;
    }
}
