package com.cyou.bi.ms.ds.recall.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyou.bi.ms.ds.recall.bean.VisitData;
import com.cyou.bi.ms.ds.recall.dao.VisitDataMapper;

@Component
public class VisitDataService {
	@Autowired
	private VisitDataMapper visitDataMapper;

	public int insertData(VisitData record) {
		int status = visitDataMapper.insertData(record);
		return status;
	}

	public List<VisitData> selectByCnmaster(
			@Param("cnmaster") String cnmaster) {
		List<VisitData> visitData = visitDataMapper.selectByCnmaster(cnmaster);
		return visitData;
	}
}
