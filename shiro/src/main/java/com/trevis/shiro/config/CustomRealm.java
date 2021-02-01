package com.trevis.shiro.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trevis.shiro.entity.UserEntity;
import com.trevis.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * @author chenyijie
 * @Date 2021/1/28 8:58 下午
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private UserService userService;


    /**
     * 授权认证,角色信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * 身份验证 从数据库中查询
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String password = String.valueOf(usernamePasswordToken.getPassword());

        UserEntity entity = userService.getOne(
                new QueryWrapper<UserEntity>()
                        .eq("name", usernamePasswordToken.getUsername())

        );

        if (entity == null) {
            throw new UnknownAccountException("账号不存在");
        } else {
            if (!password.equals(entity.getPassword())) {
                throw new IncorrectCredentialsException("密码错误");
            }
        }
        return new SimpleAccount(authenticationToken.getPrincipal(), authenticationToken.getCredentials(), getName());
    }
}
