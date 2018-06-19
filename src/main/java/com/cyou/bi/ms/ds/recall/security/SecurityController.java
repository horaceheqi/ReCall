package com.cyou.bi.ms.ds.recall.security;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {
	private static final Logger logger = LoggerFactory
			.getLogger(SecurityController.class);

	/**
	 * 首页
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String index(HttpServletRequest request) {
		return "redirect:/ds/first";
	}

	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

}