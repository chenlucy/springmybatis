
package com.example.demo.configure;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 项目常量
 */
public final class AppConfig {

	//@formatter:off
	public static final String BASE_PACKAGE = getProperty("base.package");// 项目基础包名称，根据自己公司的项目修改

	public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";// Model所在包
	public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";// Mapper所在包
	public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";// Service所在包
	public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";// ServiceImpl所在包
	public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";// Controller所在包
	public static final String CONFIG_PACKAGE = BASE_PACKAGE + ".configurer";// config所在包

	public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";// Mapper插件基础接口的完全限定名

	public static final String JDBC_URL = getProperty("spring.datasource.url");
	public static final String JDBC_USERNAME = getProperty("spring.datasource.username");
	public static final String JDBC_PASSWORD = getProperty("spring.datasource.password");
	public static final String JDBC_DIVER_CLASS_NAME = getProperty(
			"spring.datasource.driver-class-name");

	public static final String CUSTOMER_EN = getProperty("customer.en");
	public static final String CUSTOMER_CN = getProperty("customer.cn");
	public static final String PROJECT_EN = getProperty("project.en");
	public static final String PROJECT_CN = getProperty("project.cn");

	// 由于 Spring 不允许把值注入到静态变量中所以这里使用 @Value 是不起效果的
	// CasServerUrlPrefix
	public static String CAS_SERVER_URL_PREFIX = getProperty("shilo.cas.casServerUrlPrefix");
	// Cas登录页面地址
	// public static String CAS_LOGIN_URL = getProperty("shilo.cas.casLoginUrl");
	// Cas登出页面地址
	// public static String CAS_LOGOUT_URL = getProperty("shilo.cas.casLogoutUrl");
	// 当前工程对外提供的服务地址
	// public static String SHIRO_SERVER_URL_PREFIX = getProperty("shilo.cas.shiroServerUrlPrefix");
	// casFilter UrlPattern
	public static String CAS_FILTER_URL_PATTERN = getProperty("shilo.cas.casFilterUrlPattern");
	// 登录地址
	public static String LOGIN_URL = getProperty("shilo.cas.loginUrl");
	// 退出地址
	public static String LOGOUT_URL = getProperty("shilo.cas.logoutUrl");
	// 登录成功地址
	public static String SUCCESS_URL = getProperty("shilo.cas.successUrl");
	// 登录权限不够地址
	public static String UNAUTHORIZED_URL = getProperty("shilo.cas.unauthorizedUrl");

	// 缓存文件
	public static String EHCACHE_SHIRO = getProperty("shilo.cas.ehcacheShiro");
	// 回调登录地址
	public static String CALLBACK_URL = getProperty("shilo.cas.callbackUrl");

	public static boolean CACHEING_ENABLED = getPropertyB("shilo.cas.cachingEnabled");
	public static boolean AUTHENTICATION_CACHEING_ENABLED = getPropertyB(
			"shilo.cas.authenticationCachingEnabled");
	public static boolean AUTHORIZATION_CACHEING_ENABLED = getPropertyB(
			"shilo.cas.authorizationCachingEnabled");
	public static String AUTHENTICATION_CACHE_NAME = getProperty(
			"shilo.cas.authenticationCacheName");
	public static String AUTHORIZATION_CACHE_NAME = getProperty("shilo.cas.authorizationCacheName");

	public static String SECURITY_RULE_AUTHC = getProperty("spring.security.authc");
	public static String SECURITY_RULE_ANON = getProperty("spring.security.anon");
	public static String WELCOME_PAGE = getProperty("project.welcome.page");
	public static final String SEP = ",";
	
	//@formatter:on

	private static String getProperty(String name) {
		InputStream inputStream = AppConfig.class.getResourceAsStream("/config.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return p.getProperty(name);

	}

	private static boolean getPropertyB(String name) {

		return Boolean.valueOf(getProperty(name));

	}
}