package com.cyou.bi.ms.ds.recall.common;

import com.cyou.bi.ms.ds.recall.bean.PageBean;

public class Page {
	//	@Autowired
	//	private RecallSystemDataMapper recallSystemDataMapper;
	//	@Autowired
	//	private RecallDataTotalCountService recallDataTotalCountService;
	//返回开始查询的起始数值跟每页的显示的条数
	public PageBean getSelectPageNum(int totalCount, int selectPage,
			int pageSize) {
		PageBean selectPageNum = new PageBean();
		selectPageNum.setStartNum(selectPage * pageSize + 1);
		selectPageNum.setPageSize(pageSize);
		selectPageNum.setTotalPage((totalCount + pageSize - 1) / pageSize);
		return selectPageNum;
	}
}
