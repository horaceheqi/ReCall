package com.cyou.bi.ms.ds.recall.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyou.bi.ms.ds.recall.security.UserUtils;
import com.cyou.bi.ms.ds.recall.util.GetBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyou.bi.ms.ds.recall.bean.AccountsData;
import com.cyou.bi.ms.ds.recall.bean.PageBean;
import com.cyou.bi.ms.ds.recall.common.JsonService;
import com.cyou.bi.ms.ds.recall.service.AccountsDataService;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController(value = "recall主账号数据接口")
@RequestMapping(value = "/ds")
public class AccountsDataController {
	private static final Logger logger = LoggerFactory
			.getLogger(AccountsDataController.class);
	private static final String logFormat = "Processing with  body:{} ";
	@Autowired
	private AccountsDataService accountsDataService;
	private GetBody gb;
	@ApiOperation(value = "reCallCn", notes = "请求内容在body", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "body", dataType = "String", required = true, value = "请求体") })
	@RequestMapping(value = "/recallCn", method = RequestMethod.POST)
	//获取每个账号对应的所有的角色信息(包括角色评分信息)
	public String getAccountsData(HttpServletRequest request,
			HttpServletResponse response) {
		gb=new GetBody();
		String body = gb.getBody(request, response);
		String loginName = UserUtils.getCurrentUser();
		logger.info("recall role query loginName:", loginName);
		logger.info(logFormat, body);
		AccountsData param = (AccountsData) JsonService.getBean(body,
				AccountsData.class);
		PageBean reCallPageData = new PageBean();
		List<AccountsData> accountsData ;
		if (param.getCnmaster() != null && param.getCnmaster() != ""
				&& !param.getCnmaster().equals("")) {
			accountsData = accountsDataService
					.getAccountsData(param.getCnmaster());
		} else {
			accountsData = new ArrayList<AccountsData>();
			reCallPageData.setAccountsData(accountsData);
		}
		reCallPageData.setAccountsData(accountsData);
		String response_body = JsonService.toString(reCallPageData);

		logger.info("responseBody account data-reCallPageData:" + JsonService.toString(reCallPageData));
		return response_body;
	}
}
