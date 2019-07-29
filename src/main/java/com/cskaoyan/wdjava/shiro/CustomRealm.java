package com.cskaoyan.wdjava.shiro;

import com.cskaoyan.wdjava.bean.WdAdmin;
import com.cskaoyan.wdjava.service.WdUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by little Stone
 * Date 2019/5/24 Time 20:12
 */
//@Component("customRealm")
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    WdUserService userService;

    //PermissionService permissionService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();

        WdAdmin wdAdmin = userService.queryAdmin(username);
        if (wdAdmin == null) {
            return null;
        }
        String password = wdAdmin.getPassword();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(wdAdmin, password, "customRealm");

        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
