package com.cyou.bi.ms.ds.recall.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyou.bi.ms.ds.recall.dao.RecallSystemDataMapper;

@Component
public class RecallDataTotalCountService {
	@Autowired
	private RecallSystemDataMapper recallSystemDataMapper;

	//按不同条件返回的数据条数
	public int getReCallDataTotalCount(@Param("gamename") String gamename,
			@Param("cnmaster") String cnmaster, @Param("level") Integer level,
			@Param("serverid") Integer serverid,
			@Param("startLossDays") Integer startLossDays,
			@Param("endLossDays") Integer endLossDays,
			@Param("status") String status,
			@Param("startLossDate") String startLossDate,
			@Param("endLossDate") String endLossDate,
			@Param("startInterposeDate") String startInterposeDate,
			@Param("endInterposeDate") String endInterposeDate,
			@Param("startRecallDate") String startRecallDate,
			@Param("endRecallDate") String endRecallDate,
			@Param("interposeStatus") Integer interposeStatus,
			@Param("hasSystemSendGift") Integer hasSystemSendGift,
			@Param("hasManualSendGift") Integer hasManualSendGift,
			@Param("followerNumber") String followerNumber) {
		Integer totalCount = recallSystemDataMapper.selectByConditionNum(
				gamename, cnmaster, level, serverid, startLossDays, endLossDays,
				status, startLossDate, endLossDate, startInterposeDate,
				endInterposeDate, startRecallDate, endRecallDate,
				interposeStatus, hasSystemSendGift, hasManualSendGift,
				followerNumber);
		if (totalCount != null && !totalCount.equals("")) {
			return totalCount;
		} else {
			totalCount = 0;
			return totalCount;
		}

	}
}
