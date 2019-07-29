package com.cskaoyan.wdjava.config;

import com.cskaoyan.wdjava.shiro.AdminShiroRealm;
import com.cskaoyan.wdjava.shiro.CustomRealm;
import com.cskaoyan.wdjava.shiro.StudentShiroRealm;
import com.cskaoyan.wdjava.shiro.UserModularRealmAuthenticator;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by little Stone
 * Date 2019/7/9 Time 20:26
 */
//@Configuration
public class ShiroConfig {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    //最开始的realm
	/*@Bean
	public CustomRealm customRealm(){
		CustomRealm customRealm = new CustomRealm();
		return customRealm;
	}*/
    @Bean
    public AdminShiroRealm adminShiroRealm() {
        AdminShiroRealm adminShiroRealm = new AdminShiroRealm();
        return adminShiroRealm;
    }

    @Bean
    public StudentShiroRealm studentShiroRealm() {
        StudentShiroRealm studentShiroRealm = new StudentShiroRealm();
        return studentShiroRealm;
    }

    /**
     * 系统自带的Realm管理，主要针对多realm
     */
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator() {
        //自己重写的ModularRealmAuthenticator
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        List<Realm> realms = new ArrayList<>();
        realms.add(adminShiroRealm());
        realms.add(studentShiroRealm());
        modularRealmAuthenticator.setRealms(realms);
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {

        //增加realm
        List<Realm> realms = new ArrayList<>();
        realms.add(adminShiroRealm());
        realms.add(studentShiroRealm());
        logger.info("配置的realms为：" + realms);
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager(realms);


        //defaultWebSecurityManager.setRealms(realms);
        defaultWebSecurityManager.setAuthenticator(modularRealmAuthenticator());
        //defaultWebSecurityManager.setSessionManager(defaultWebSessionManager());
        defaultWebSecurityManager.setSessionManager(defaultWebSessionManager());
        return defaultWebSecurityManager;

    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        filterMap.put("/adminLogin", "anon");
        filterMap.put("/studentLogin", "anon");
        filterMap.put("/info", "anon");
        filterMap.put("/admin", "anon");
        filterMap.put("/admin/index", "anon");
        //filterMap.put("/admin/dashboard","anon");
        filterMap.put("/**", "authc");

        shiroFilterFactoryBean.setLoginUrl("/adminLogin");
        //shiroFilterFactoryBean.setSuccessUrl("/admin/auth/index");
        //shiroFilterFactoryBean.setUnauthorizedUrl("/admin/auth/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSessionManager defaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setGlobalSessionTimeout(600000);
        return sessionManager;
    }
	/*@Bean
	public SessionManager sessionManager(){
		MallShiroSessionManager mallShiroSessionManager = new MallShiroSessionManager();
		mallShiroSessionManager.setGlobalSessionTimeout(600000);
		return mallShiroSessionManager;
	}*/


	/*@Bean
	@Order(Integer.MIN_VALUE)
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	//@DependsOn("lifecycleBeanPostProcessor")
	public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}*/

}
