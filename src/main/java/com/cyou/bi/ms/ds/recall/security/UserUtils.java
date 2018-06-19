/*
 * Copyright (c) 2017, CHANGYOU.COM. All rights reserved.
 *
 */

package com.cyou.bi.ms.ds.recall.security;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 用户工具类.
 *
 *
 * @author chufucun
 * @since 1.0
 */
public class UserUtils {

	public static final String SECURITY_FTP_CLIENT = "SECURITY_FTP_CLIENT";
	public static final String PROCESS_INFO = "PROCESS_INFO";

	private static final Log logger = LogFactory.getLog(UserUtils.class);

	/**
	 * 获得当前登录的用户
	 * 
	 */
	public static String getCurrentUser() {

		SecurityContextImpl securityContextImpl = null;

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(false);

		if (session != null) {
			securityContextImpl = (SecurityContextImpl) session
					.getAttribute("SPRING_SECURITY_CONTEXT");
		}

		// securityContextImpl = (SecurityContextImpl) request
		// .getSession().getAttribute("SPRING_SECURITY_CONTEXT");

		if (securityContextImpl == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("用户未登录!");
			}
			return null;
		}
		Authentication authentication = securityContextImpl.getAuthentication();
		String loginName = authentication.getName();

		if (logger.isDebugEnabled()) {
			// 登录名
			System.out.println("Username : " + authentication.getName());
			WebAuthenticationDetails details = (WebAuthenticationDetails) authentication
					.getDetails();
			// 获得访问地址
			System.out.println("RemoteAddress : " + details.getRemoteAddress());
			// 获得sessionid
			System.out.println("SessionId : " + details.getSessionId());
			// 获得当前用户所拥有的权限
			List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication
					.getAuthorities();
			for (GrantedAuthority grantedAuthority : authorities) {
				System.out.println(
						"Authority : " + grantedAuthority.getAuthority());
			}
		}
		return loginName;
	}

	/**
	 * 获得处理进度信息
	 * 
	 * @param file
	 * @return
	 */
	public static String getProcessInfo(String file) {
		HttpSession session = getSession();
		if (session != null) {
			String key = PROCESS_INFO + StringUtils.replace(file, "/", "_");
			String msg = (String) session.getAttribute(key);
			if (StringUtils.isNotBlank(msg)) {
				return msg;
			}
		}
		return "";
	}

	/**
	 * 设置处理进度信息
	 * 
	 * @param file
	 * @return
	 */
	public static boolean setProcessInfo(String file, String msg) {
		HttpSession session = getSession();
		if (session != null) {
			String key = PROCESS_INFO + StringUtils.replace(file, "/", "_");
			if (StringUtils.isNotBlank(msg)) {
				session.setAttribute(key, msg);
			} else {
				session.removeAttribute(key);
			}
		}
		return false;
	}

	/**
	 * 获得用户的session
	 * 
	 * @return
	 */
	private static HttpSession getSession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(false);

		return session;

	}

}
