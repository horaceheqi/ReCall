package com.cyou.bi.ms.ds.recall.bean;

public class VisitData {
	private String cnmaster;

	private String visitHistory;

	private String dt;

	public String getCnmaster() {
		return cnmaster;
	}

	public void setCnmaster(String cnmaster) {
		this.cnmaster = cnmaster == null ? null : cnmaster.trim();
	}

	public String getVisitHistory() {
		return visitHistory;
	}

	public void setVisitHistory(String visitHistory) {
		this.visitHistory = visitHistory == null ? null : visitHistory.trim();
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}
}