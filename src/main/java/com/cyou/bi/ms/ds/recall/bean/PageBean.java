package com.cyou.bi.ms.ds.recall.bean;

import java.util.List;

public class PageBean {
	private List<RecallSystemData> data;
	private List<AccountsData> accountsData;
	private List<VisitData> visitData;
	private Integer firstPage;//第一页
	private Integer prePgae; //上一页
	private Integer nextPage;//下一页
	private Integer totalPage;//总页数
	private Integer currentPage;//当前页
	private Integer totalCount;//总条数
	private Integer pageSize;//每页的条数
	private Integer selectPage;//选择的第几页
	private Integer startNum;//开始的页数

	public List<RecallSystemData> getData() {
		return data;
	}

	public void setData(List<RecallSystemData> data) {
		this.data = data;
	}

	public Integer getFirstPage() {
		firstPage = 1;
		return firstPage;
	}

	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}

	public Integer getPrePgae() {
		if (currentPage <= 1) {
			return 1;
		}
		return prePgae - 1;
	}

	public void setPrePgae(Integer prePgae) {
		this.prePgae = prePgae;
	}

	public Integer getNextPage() {
		if (currentPage >= totalPage) {
			return totalPage;
		}
		return nextPage + 1;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage(Integer totalCount, Integer pageSize) {
		totalPage = (totalCount + pageSize - 1) / pageSize;
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getSelectPage() {
		return selectPage;
	}

	public void setSelectPage(Integer selectPage) {
		this.selectPage = selectPage;
	}

	public Integer getStartNum(Integer selectPage, Integer pageSize) {
		startNum = (selectPage - 1) * pageSize;
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public List<AccountsData> getAccountsData() {
		return accountsData;
	}

	public void setAccountsData(List<AccountsData> accountsData) {
		this.accountsData = accountsData;
	}

	public List<VisitData> getVisitData() {
		return visitData;
	}

	public void setVisitData(List<VisitData> visitData) {
		this.visitData = visitData;
	}

}
