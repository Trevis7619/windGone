package com.trevis.shiro.config;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenyijie
 * @Date 2021/1/28 8:59 下午
 * shiro配置类
 */
@Configuration
@Slf4j
public class ShiroConfig {

    /**
     * 注入AuthorizingRealm
     * relam对象
     */
    @Bean("customRealm")
    public CustomRealm customRealm() {
        //redis
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("127.0.0.1");
        redisManager.setPort(6380);

        //shiro缓存管理器
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        //唯一标识
        redisCacheManager.setPrincipalIdFieldName("id");
        redisCacheManager.setRedisManager(redisManager);
        log.info("redis缓存管理器:{}", new Gson().toJson(redisCacheManager));


        CustomRealm customRealm = new CustomRealm();
        //开启全局缓存
        customRealm.setCachingEnabled(true);
        //开启认证缓存
        customRealm.setAuthenticationCachingEnabled(true);
        customRealm.setCacheManager(redisCacheManager);
        return customRealm;
    }

    /**
     * 管理器,注入自定义的realm
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        //securityManager.setCacheManager(myRedisCacheManager);   全局缓存处理,单一relam可以在relam中配置缓存处理方案
        return securityManager;
    }


    /**
     * shiro过滤器,factory注入manager
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterMap = new LinkedHashMap<>();
        //放开拦截
        filterMap.put("/shiro/login/**", "anon");
        filterMap.put("login.html", "anon");
        //放开静态资源
        filterMap.put("/statics/**", "anon");

        //拦截所有
       // filterMap.put("/**", "authc");
        filterMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        //默认认证路径 默认login.jsp
        shiroFilterFactoryBean.setLoginUrl("/login.html");

        return shiroFilterFactoryBean;
    }

}
