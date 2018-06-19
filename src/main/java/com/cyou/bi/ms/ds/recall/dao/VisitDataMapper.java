package com.cyou.bi.ms.ds.recall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyou.bi.ms.ds.recall.bean.VisitData;

public interface VisitDataMapper {
	int insertData(VisitData record);

	List<VisitData> selectByCnmaster(@Param("cnmaster") String cnmaster);

	int insertSelective(VisitData record);
}