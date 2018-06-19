package com.cyou.bi.ms.ds.recall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyou.bi.ms.ds.recall.bean.RecallSystemData;

public interface RecallSystemDataMapper {
	int deleteByPrimaryKey(String cnmaster);

	int insert(RecallSystemData record);

	int insertSelective(RecallSystemData record);

	RecallSystemData selectByPrimaryKey(String cnmaster);

	int updateByPrimaryKeySelective(RecallSystemData record);

	int updateByPrimaryKeyWithBLOBs(RecallSystemData record);

	int updateByPrimaryKey(RecallSystemData record);

	//更新回访记录明细
	int updateByCnmasterVisit(@Param("cnmaster") String cnmaster,
			@Param("visitHistory") String visitHistory,
			@Param("interposeDate") String interposeDate,
			@Param("interposeStatus") Integer interposeStatus,
			@Param("hasManualSendGift") Integer hasManualSendGift);

	//根据不同的条件返回数据总条数
	Integer selectByConditionNum(@Param("gamename") String gamename,
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
			@Param("followerNumber") String followerNumber);

	//按条件查询分页显示
	List<RecallSystemData> selectByCondition(@Param("gamename") String gamename,
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
			@Param("pageSize") Integer pageSize);

	//导出数据Excel表
	List<RecallSystemData> selectByConditionExcel(RecallSystemData param);
}