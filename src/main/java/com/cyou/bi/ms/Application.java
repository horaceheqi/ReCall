/*
 * Copyright (c) 2017, CHANGYOU.COM. All rights reserved.
 *
 */

package com.cyou.bi.ms;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.catalina.filters.RemoteIpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 
 * @author 
 * @see
 * @since 1.0
 */
@SpringBootApplication
@ImportResource("classpath:application-context.xml")
public class Application {

	private static final Logger log = LoggerFactory
			.getLogger(Application.class);

	/**
	 * 过滤器: 将代理服务器发来的请求包含的IP地址转换成真正的用户IP。Tomcat 8 提供了对应的过滤器：RemoteIpFilter
	 * 
	 * @return
	 */
	@Bean
	public RemoteIpFilter remoteIpFilter() {

		return new RemoteIpFilter();
	}

	/**
	 * 过滤器: 字符编码过滤器
	 * 
	 * @return
	 */
	@Bean
	public CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	/**
	 * Main method, used to run the application.
	 *
	 * @param args the command line arguments
	 * @throws UnknownHostException if the local host name could not be resolved
	 *           into an address
	 */
	public static void main(String[] args) throws UnknownHostException {

		ApplicationContext application = SpringApplication
				.run(Application.class, args);

		Environment env = application.getEnvironment();
		String protocol = "http";
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		log.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t"
						+ "Local: \t\t{}://localhost:{}\n\t"
						+ "External: \t{}://{}:{}\n\t"
						+ "Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), protocol,
				env.getProperty("server.port"), protocol,
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"), env.getActiveProfiles());
	}

}
