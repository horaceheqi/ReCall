package com.cyou.bi.ms.ds.recall.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyou.bi.ms.ds.recall.util.GetBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyou.bi.ms.ds.recall.bean.PageBean;
import com.cyou.bi.ms.ds.recall.bean.RecallSystemData;
import com.cyou.bi.ms.ds.recall.bean.UpdateStatus;
import com.cyou.bi.ms.ds.recall.common.JsonService;
import com.cyou.bi.ms.ds.recall.security.UserUtils;
import com.cyou.bi.ms.ds.recall.service.ReCallSystemDataService;
import com.cyou.bi.ms.ds.recall.service.RecallDataTotalCountService;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller(value = "recall数据接口")
@RequestMapping(value = "/ds")
public class RecallSystemDataController {
	private static final Logger logger = LoggerFactory
			.getLogger(RecallSystemDataController.class);
	private static final String logFormat = "Processing with  body:{} ";
	@Autowired
	private ReCallSystemDataService reCallSystemDataService;
	@Autowired
	private RecallDataTotalCountService recallDataTotalCountService;
	private GetBody gb;
	int number = 0;

	@ApiOperation(value = "reCall", notes = "请求内容在body", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "body", dataType = "String", required = true, value = "请求体") })
     //登录后返回首页面
	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public String first() {
		return "index_statistic";
	}

	@RequestMapping(value = "/recall", method = RequestMethod.POST)
	@ResponseBody
	//跟据提供的查询条件返回对应的查询的数据包括总条数跟总页数(每页显示10条数据)
	public String getReCallDatas(HttpServletRequest request,
			HttpServletResponse response) {
		String loginName = UserUtils.getCurrentUser();
		gb=new GetBody();
		String body = gb.getBody(request, response);
		logger.info(logFormat, body);
		logger.info("recall-data query loginName:" + loginName);
		this.number = 20;
		PageBean reCallDataStartNum = new PageBean();
		//获取传递过来的查询页数跟每页显示的条数
		PageBean paramPage = (PageBean) JsonService.getBean(body,
				PageBean.class);
		logger.info("recall-data paramPage：" + JsonService.toString(paramPage));
		//获取传递过来的查询条件
		RecallSystemData param = (RecallSystemData) JsonService.getBean(body,
				RecallSystemData.class);
		Integer totalCount = getByConditionTotalCount(param);
		this.number = 40;
		logger.info("totalCount:" + totalCount);
		List<RecallSystemData> recallData = null;
		//根据传递的条件判断查询数据
		if (paramPage.getSelectPage() == null
				|| paramPage.getSelectPage().equals("")) {
			if (paramPage.getPageSize() == null
					|| paramPage.getPageSize().equals("")
					|| paramPage.getPageSize() == 0) {
				paramPage.setSelectPage(1);
				paramPage.setPageSize(10);
				recallData = getReCallData(param, paramPage);
				this.number = 80;
			} else {
				paramPage.setSelectPage(1);
				recallData = getReCallData(param, paramPage);
				this.number = 80;
			}
		} else {
			if (paramPage.getPageSize() == null
					|| paramPage.getPageSize().equals("")
					|| paramPage.getPageSize() == 0) {
				paramPage.setPageSize(10);
				paramPage.setStartNum(reCallDataStartNum.getStartNum(
						paramPage.getSelectPage(), paramPage.getPageSize()));
				recallData = getReCallData(param, paramPage);
				this.number = 80;
			} else {
				recallData = getReCallData(param, paramPage);
				this.number = 80;
			}
		}
		//封装查询的数据返回到前台(json格式)
		PageBean reCallPageData = new PageBean();
		reCallPageData.setData(recallData);
		reCallPageData.setTotalCount(totalCount);
		reCallPageData.setTotalPage(reCallPageData.getTotalPage(totalCount,
				paramPage.getPageSize()));
		this.number = 95;
		String response_body = JsonService.toString(reCallPageData);
		logger.info("response_body recall-data-reCallPageData:" + JsonService.toString(reCallPageData));
		return response_body;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	//根据回访信息更新回访记录干预时间,干预状态
	public String updateVisitData(HttpServletRequest request,
			HttpServletResponse response) {
		gb=new GetBody();
		String body = gb.getBody(request, response);
		String loginName = UserUtils.getCurrentUser();
		logger.info("update visit loginName:", loginName);
		logger.info(logFormat, body);
		int updateVisit = 0;
		UpdateStatus status = new UpdateStatus();
		RecallSystemData updateParam = (RecallSystemData) JsonService
				.getBean(body, RecallSystemData.class);
		if (updateParam.getVisitHistory() != null
				&& updateParam.getVisitHistory() != ""
				&& !updateParam.getVisitHistory().equals("")) {
			if (updateParam.getCnmaster() != null
					&& updateParam.getCnmaster() != ""
					&& !updateParam.getCnmaster().equals("")) {
				updateVisit = reCallSystemDataService.updateVisit(
						updateParam.getCnmaster(),
						updateParam.getVisitHistory(),
						updateParam.getInterposeDate(),
						updateParam.getInterposeStatus(),
						updateParam.getHasManualSendGift());
				status.setStatus(updateVisit);
			} else {
				status.setStatus(0);
				//status.setError("主账号内容是空,请填写内容后提交");
			}
		} else {
			status.setStatus(0);
			//status.setError("更改内容是空或者是更改内容跟主账号都为空,请填写内容后提交");
		}
		//返回更新状态
		String response_body = JsonService.toString(status);
		logger.info("responseBody visit-update-status:" + response_body);
		return response_body;
	}

	@RequestMapping(value = "/probar", method = RequestMethod.POST)
	@ResponseBody
	//查询数据时的进度条信息
	public String probar() {
		int num = this.number;
		UpdateStatus probar = new UpdateStatus();
		probar.setProbar(num);
		String response_body = JsonService.toString(probar);
		logger.info("response_body probar:" + JsonService.toString(probar));
		return response_body;
	}

	//获取总条数
	public Integer getByConditionTotalCount(RecallSystemData param) {
		Integer totalCount = recallDataTotalCountService
				.getReCallDataTotalCount(param.getGamename(),
						param.getCnmaster(), param.getLevel(),
						param.getServerid(), param.getStartLossDays(),
						param.getEndLossDays(), param.getStatus(),
						param.getStartLossDate(), param.getEndLossDate(),
						param.getStartInterposeDate(),
						param.getEndInterposeDate(), param.getStartRecallDate(),
						param.getEndRecallDate(), param.getInterposeStatus(),
						param.getHasSystemSendGift(),
						param.getHasManualSendGift(),
						param.getFollowerNumber());
		return totalCount;
	}

	//根据条件查询数据
	public List<RecallSystemData> getReCallData(RecallSystemData param,
			PageBean paramPage) {
		List<RecallSystemData> recallSystemData = reCallSystemDataService
				.getData(param.getGamename(), param.getCnmaster(),
						param.getLevel(), param.getServerid(),
						param.getStartLossDays(), param.getEndLossDays(),
						param.getStatus(), param.getStartLossDate(),
						param.getEndLossDate(), param.getStartInterposeDate(),
						param.getEndInterposeDate(), param.getStartRecallDate(),
						param.getEndRecallDate(), param.getInterposeStatus(),
						param.getHasSystemSendGift(),
						param.getHasManualSendGift(), param.getFollowerNumber(),
						paramPage.getStartNum(paramPage.getSelectPage(),
								paramPage.getPageSize()),
						paramPage.getPageSize());
		return recallSystemData;
	}

}
