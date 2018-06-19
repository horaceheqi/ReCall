package com.cyou.bi.ms.ds.recall.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyou.bi.ms.ds.recall.bean.RecallSystemData;
import com.cyou.bi.ms.ds.recall.dao.RecallSystemDataMapper;

@Component
public class ExcelService {
	@Autowired
	private RecallSystemDataMapper recallSystemDataMapper;

	//导出数据Excel表
	public List<RecallSystemData> getDataExcel(RecallSystemData param) {
		List<RecallSystemData> dataExcel = recallSystemDataMapper
				.selectByConditionExcel(param);
		return dataExcel;
	}
}
