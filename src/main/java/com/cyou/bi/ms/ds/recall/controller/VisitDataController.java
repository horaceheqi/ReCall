package com.cyou.bi.ms.ds.recall.controller;


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

import com.cyou.bi.ms.ds.recall.bean.PageBean;
import com.cyou.bi.ms.ds.recall.bean.UpdateStatus;
import com.cyou.bi.ms.ds.recall.bean.VisitData;
import com.cyou.bi.ms.ds.recall.common.JsonService;
import com.cyou.bi.ms.ds.recall.service.VisitDataService;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController(value = "recall保存回访数据接口")
@RequestMapping(value = "/ds")
public class VisitDataController {
	private static final Logger logger = LoggerFactory
			.getLogger(VisitDataController.class);
	private static final String logFormat = "Processing with  body:{} Processing with  visitdata:{}";
	@Autowired
	private VisitDataService visitDataService;
	private GetBody gb;
	@ApiOperation(value = "reCallVisit", notes = "请求内容在body", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "body", dataType = "String", required = true, value = "请求体"),
			@ApiImplicitParam(paramType = "form", name = "data", dataType = "String", required = true, value = "请求体") })

	@RequestMapping(value = "/visitInsert", method = RequestMethod.POST)
	//回访数据保存历史数据(单独一张回访记录表保存历史回访记录)
	public String insertVisitData(HttpServletRequest request,
			HttpServletResponse response) {
		gb=new GetBody();
		String body = gb.getBody(request, response);
		String loginName = UserUtils.getCurrentUser();
		logger.info("VisitData-Insert loginName:", loginName);
		logger.info(logFormat, body);
		VisitData record = (VisitData) JsonService.getBean(body,
				VisitData.class);
		logger.info("VisitData-Insert record:" + JsonService.toString(record));
		UpdateStatus status = new UpdateStatus();
		if (record.getCnmaster() == null || record.getCnmaster().equals("")) {
			status.setStatus(0);
		}
		int statusVisit = visitDataService.insertData(record);
		status.setStatus(statusVisit);
		String response_body = JsonService.toString(status);
		logger.info("responseBody VisitData-Insert-status:" + JsonService.toString(status));
		return response_body;
	}

	@RequestMapping(value = "/visitSelect", method = RequestMethod.POST)
	//历史回访记录查询(默认全部返回)
	public String selectVisitData(HttpServletRequest request,
			HttpServletResponse response) {
		gb=new GetBody();
		String body = gb.getBody(request, response);
		String loginName = UserUtils.getCurrentUser();
		logger.info("VisitData-Query loginName:", loginName);
		logger.info(logFormat, body);
		VisitData record = (VisitData) JsonService.getBean(body,
				VisitData.class);
		logger.info("VisitData-Query record:" + JsonService.toString(record));
		PageBean visitData = new PageBean();
		List<VisitData> visitDatas = null;
		if (record.getCnmaster() != null && !record.getCnmaster().equals("")
				&& record.getCnmaster() != "") {
			visitDatas = visitDataService
					.selectByCnmaster(record.getCnmaster());
		}
		visitData.setVisitData(visitDatas);
		String response_body = JsonService.toString(visitData);
		logger.info("responseBody VisitData-Query-visitData:" + JsonService.toString(visitData));
		return response_body;
	}
}
