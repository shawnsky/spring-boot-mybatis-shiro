package com.xt;/**
 * Created by Administrator on 2017/7/6.
 */

import com.xt.shiro.SessionRedisDao;
import com.xt.shiro.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * 07-06 16:00
 * shiro 配置类
 * @author xt
 **/
@Configuration
public class ShiroConfiguration {

    /**
     * Get shiro realm user realm.
     * Realm 实现
     * @return the user realm
     */
    @Bean(name = "SecurityRealm")
    public UserRealm getShiroRealm(){
        UserRealm userRealm = new UserRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }


    /**
     * Gets eh cache manager.
     * 缓存管理器，用ehcache实现
     * 参与了Session缓存和授权信息缓存
     * @return the eh cache manager
     */
    @Bean(name = "shiroEhcacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }



    /**
     * Gets java uuid session id generator.
     * 会话 ID 生成器
     * @return the java uuid session id generator
     */
    @Bean(name = "javaUuidSessionIdGenerator")
    public JavaUuidSessionIdGenerator getJavaUuidSessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }



    /**
     * Gets enterprise cache session dao.
     * 会话 DAO
     * @return the enterprise cache session dao
     */
    @Bean(name = "enterpriseCacheSessionDAO")
    public EnterpriseCacheSessionDAO getEnterpriseCacheSessionDAO() {
//        EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
        EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new SessionRedisDao();//使用自己的DAO
        enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        enterpriseCacheSessionDAO.setSessionIdGenerator(getJavaUuidSessionIdGenerator());
        return enterpriseCacheSessionDAO;
    }




    /**
     * Gets simple cookie.
     * 会话 cookie 模板
     * @return the simple cookie
     */
    @Bean(name = "simpleCookie")
    public SimpleCookie getSimpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("sessionId");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(1800000);
        return simpleCookie;
    }




    /**
     * Get default web session manager default web session manager.
     * 会话管理器
     * @return the default web session manager
     */
    @Bean(name="defaultWebSessionManager")
    public DefaultWebSessionManager getDefaultWebSessionManager(){
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setGlobalSessionTimeout(1800000);//30m
        defaultWebSessionManager.setDeleteInvalidSessions(true);
        defaultWebSessionManager.setSessionDAO(getEnterpriseCacheSessionDAO());
        defaultWebSessionManager.setSessionIdCookie(getSimpleCookie());
        defaultWebSessionManager.setSessionIdCookieEnabled(true);
        return defaultWebSessionManager;
    }

    /**
     * Remember me cookie simple cookie.
     * 记住我cookie
     * @return the simple cookie
     */
    @Bean(name = "rememberMeCookie")
    public SimpleCookie rememberMeCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(2592000);//30d
        return simpleCookie;
    }

    /**
     * Remember me manager cookie remember me manager.
     * 记住我管理器
     * @return the cookie remember me manager
     */
    @Bean(name = "rememberMeManager")
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        byte[] cipherKey = Base64.decode("3AvVhmFLUs0KTA3Kprsdag==");
        cookieRememberMeManager.setCipherKey(cipherKey);
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }


    /**
     * Gets default web security manager.
     * 安全管理器
     * @return the default web security manager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(getShiroRealm());
        manager.setSessionManager(getDefaultWebSessionManager());
        manager.setCacheManager(getEhCacheManager());
        return manager;
    }


    /**
     * Gets default advisor auto proxy creator.
     * AOP式权限检查 这个类会扫描上下文 寻找所有的advisor  并把advisor切入到 bean中
     * @return the default advisor auto proxy creator
     */
//    @Bean
//    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
//        daap.setProxyTargetClass(true);
//        return daap;
//    }

    /**
     * Gets authorization attribute source advisor.
     * AOP权限注解
     * @return the authorization attribute source advisor
     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
//        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
//        aasa.setSecurityManager(getDefaultWebSecurityManager());
//        return new AuthorizationAttributeSourceAdvisor();
//    }


    /**
     * Gets shiro filter factory bean.
     * shiro filter 访问控制核心
     * @return the shiro filter factory bean
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        bean.setSecurityManager(getDefaultWebSecurityManager());

        bean.setLoginUrl("/login");
        bean.setUnauthorizedUrl("/unauthorized");


        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/developAgent", "perms[support:agent]");
        filterChainDefinitionMap.put("/authBook","perms[data:authbook]");
        filterChainDefinitionMap.put("/admin/**","roles[admin]");
        filterChainDefinitionMap.put("/login", "authc");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "user");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);



        Map<String, Filter> filters = new HashMap<>();
        filters.put("anon", new AnonymousFilter());
        filters.put("authc", new FormAuthenticationFilter());
        filters.put("logout", new LogoutFilter());
        filters.put("roles", new RolesAuthorizationFilter());
        filters.put("user", new UserFilter());
        bean.setFilters(filters);

        return bean;
    }


    /**
     * Gets lifecycle bean post processor.
     * 生命周期管理器
     * @return the lifecycle bean post processor
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
