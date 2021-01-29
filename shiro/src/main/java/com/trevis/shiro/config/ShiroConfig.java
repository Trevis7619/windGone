package com.trevis.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
public class ShiroConfig {

    /**
     * 注入AuthorizingRealm
     * relam对象
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }


    /**
     * 管理器,注入自定义的realm
     */
    @Bean("securityManager")
    public SessionsSecurityManager securityManager(CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm);
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
        filterMap.put("/shiro/init","anon");
        filterMap.put("/login/**","anon");
        filterMap.put("login.html","anon");
        //放开静态资源
        filterMap.put("/statics/**","anon");

        //拦截所有
        filterMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }




}
