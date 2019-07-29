package com.cskaoyan.wdjava.controller;

import com.cskaoyan.wdjava.shiro.WdUserToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by little Stone
 * Date 2019/7/9 Time 20:22
 */
@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 管理员登陆
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("adminLogin")
    public String adminLogin(String username, String password) {

        //UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //WdUserToken userToken = new WdUserToken(username, password, "Admin");
        //Subject subject = SecurityUtils.getSubject();
        try {
            //subject.login(userToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            logger.info("认证失败:" + e);
            return "/";
            //e.printStackTrace();
        }
        return "adminIndex";
    }

    @RequestMapping("studentLogin")
    public String studentLogin(String username, String password) {

        //UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //WdUserToken userToken = new WdUserToken(username, password, "Student");
        //Subject subject = SecurityUtils.getSubject();
        try {
            //subject.login(userToken);
        } catch (AuthenticationException e) {
            logger.info("认证失败:" + e);
            return "/";
            //e.printStackTrace();
        }
        return "studentIndex";
    }


    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }

}
