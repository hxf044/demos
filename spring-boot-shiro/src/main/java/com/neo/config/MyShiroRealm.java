package com.neo.config;

import com.neo.entity.SysPermission;
import com.neo.entity.SysRole;
import com.neo.entity.UserInfo;
import com.neo.sevice.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        for (SysRole role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p : role.getPermissions()) {
                //根据你的这个字段来拦截前端请求
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.printf("正在验证身份...");
        SimpleAuthenticationInfo info = null;
        //将token转换成UsernamePasswordTokenSystem.out.printf("----->"+username);
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //从转换后的token中获取用户名 查询数据库，得到用户
        UserInfo user = userInfoService.findByUsername(upToken.getUsername());
        if (user != null) {
            //user: user用户对象 getPassword() 密码  getName() realm name
            info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
        return info;
    }
}