package com.cyou.bi.ms.ds.recall.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyou.bi.ms.ds.recall.bean.RecallSystemData;
import com.cyou.bi.ms.ds.recall.dao.RecallSystemDataMapper;

@Component
public class ReCallSystemDataService {
	@Autowired
	private RecallSystemDataMapper recallSystemDataMapper;

	//根据条件查询数据
	public List<RecallSystemData> getData(@Param("gamename") String gamename,
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
			@Param("followerNumber") String followerNumber,
			@Param("startNum") Integer startNum,
			@Param("pageSize") Integer pageSize) {

		List<RecallSystemData> recallData = recallSystemDataMapper
				.selectByCondition(gamename, cnmaster, level, serverid,
						startLossDays, endLossDays, status, startLossDate,
						endLossDate, startInterposeDate, endInterposeDate,
						startRecallDate, endRecallDate, interposeStatus,
						hasSystemSendGift, hasManualSendGift, followerNumber,
						startNum, pageSize);
		return recallData;
	}

	//更新回访记录明细 updateByCnmasterVisit
	public int updateVisit(@Param("cnmaster") String cnmaster,
			@Param("visitHistory") String visitHistory,
			@Param("interposeDate") String interposeDate,
			@Param("interposeStatus") Integer interposeStatus,
			@Param("hasManualSendGift") Integer hasManualSendGift) {
		int updateData = recallSystemDataMapper.updateByCnmasterVisit(cnmaster,
				visitHistory, interposeDate, interposeStatus,
				hasManualSendGift);
		return updateData;
	}
}
