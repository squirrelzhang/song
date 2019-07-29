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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 管理员认证授权域
 * stone
 */
public class AdminShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(AdminShiroRealm.class);

    @Autowired
    WdUserService userService;

    /**
     * 认证 stone
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("认证管理员身份");
        //通过token取出username
        WdUserToken userToken = (WdUserToken) authenticationToken;
        String username = userToken.getUsername();

        WdAdmin wdAdmin = userService.queryAdmin(username);
        if (wdAdmin == null) {
            throw new AuthenticationException();
        }
        String password = wdAdmin.getPassword();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(wdAdmin, password, getName());

        return info;

    }

    /**
     * 授权 stone
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
