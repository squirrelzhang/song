package com.cskaoyan.wdjava.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 增加类型成员变量 用于不同的realm的判断
 */
public class WdUserToken extends UsernamePasswordToken {

    //登录类型，判断是学生登录，教师登录还是管理员登录
    private String loginType;

    public WdUserToken(final String username, final String password, String loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
