package com.cyou.bi.ms.ds.recall.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cyou.bi.ms.ds.recall.service.SecurityService;

@Configuration
//@EnableWebSecurity: 禁用Boot的默认Security配置，配合@Configuration启用自定义配置
//（需要扩展WebSecurityConfigurerAdapter）
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true): 启用Security注解，
//例如最常用的@PreAuthorize
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SecurityService securityService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// Configure spring security's authenticationManager with custom
		// user details service
		auth.userDetailsService(this.securityService);
	}

	@Override
	//configure(HttpSecurity): Request层面的配置，对应XML Configuration中的<http>元素
	//定义URL路径应该受到保护，哪些不应该
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() // 暂时禁用跨域攻击防护，后面有需要再配置
				.authorizeRequests()
				.antMatchers("/", "/home", "/assets/**", "/static/**")
				.permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll()
				.and() // 两天有效
				.rememberMe().tokenValiditySeconds(2 * 24 * 60 * 60);
		//		http.authorizeRequests()
		//				// 例如以下代码指定了/和/index不需要任何认证就可以访问，其他的路径都必须通过身份验证。
		//				.antMatchers("/", "/index").permitAll().anyRequest()
		//				.authenticated().and()
		//				//通过formLogin()定义当需要用户登录时候，转到的登录页面。
		//				.formLogin().loginPage("/login").permitAll().and()
		//				//注销
		//				.logout().permitAll();
		//		//关闭csrf 防止循环定向
		//		http.csrf().disable();
	}
}
