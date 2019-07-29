package com.cskaoyan.wdjava.shiro;

import com.cskaoyan.wdjava.bean.WdStudentInfo;
import com.cskaoyan.wdjava.service.WdStudentInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * 学生信息认证域 stone
 */
public class StudentShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(StudentShiroRealm.class);

    //在自定义Realm中注入的Service声明中加入@Lazy注解即可解决@cacheble注解无效问题
    //解决同时使用Redis缓存数据和缓存shiro时，@cacheble无效的问题
    @Autowired
    @Lazy
    private WdStudentInfoService studentService;

    /**
     * 认证 stone
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        logger.info("开始学生身份认证");

        WdUserToken userToken = (WdUserToken) authenticationToken;

        String username = userToken.getUsername();

        WdStudentInfo studentInfo = studentService.queryStudentByName(username);

        if (studentInfo == null) {
            logger.info("未查询到user的信息");
            throw new UnknownAccountException("用户不存在");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(studentInfo, studentInfo.getPassword(), getName());
        return authenticationInfo;
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
