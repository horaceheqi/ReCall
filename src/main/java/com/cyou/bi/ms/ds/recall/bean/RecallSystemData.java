package com.cyou.bi.ms.ds.recall.bean;

public class RecallSystemData {
	private String cnmaster;

	private String status;

	private String lossDate;
	private Integer serverid;
	private Double lossMoney;
	private Integer startLossDays;
	private Integer endLossDays;
	private Integer lossDays;
	private String recallDate;
	private String startRecallDate;
	private String endRecallDate;
	private Double recallMoney;

	private Integer level;

	private String gamename;

	private String generateDate;
	private String startLossDate;
	private String endLossDate;
	private String phoneNumber;

	private String interposeDate;
	private String startInterposeDate;
	private String endInterposeDate;
	private Integer interposeStatus;

	private Integer isLoss;

	private Integer isRecall;

	private Integer hasSystemSendGift;

	private Integer hasManualSendGift;

	private String followerNumber;

	private String visitHistory;

	public String getCnmaster() {
		return cnmaster;
	}

	public void setCnmaster(String cnmaster) {
		this.cnmaster = cnmaster == null ? null : cnmaster.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getLossDate() {
		return lossDate;
	}

	public void setLossDate(String lossDate) {
		this.lossDate = lossDate;
	}

	public Double getLossMoney() {
		return lossMoney;
	}

	public void setLossMoney(Double lossMoney) {
		this.lossMoney = lossMoney;
	}

	public String getRecallDate() {
		return recallDate;
	}

	public void setRecallDate(String recallDate) {
		this.recallDate = recallDate;
	}

	public Double getRecallMoney() {
		return recallMoney;
	}

	public void setRecallMoney(Double recallMoney) {
		this.recallMoney = recallMoney;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getGamename() {
		return gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename == null ? null : gamename.trim();
	}

	public String getGenerateDate() {
		return generateDate;
	}

	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
	}

	public String getInterposeDate() {
		return interposeDate;
	}

	public void setInterposeDate(String interposeDate) {
		this.interposeDate = interposeDate == null ? null
				: interposeDate.trim();
	}

	public Integer getInterposeStatus() {
		return interposeStatus;
	}

	public void setInterposeStatus(Integer interposeStatus) {
		this.interposeStatus = interposeStatus;
	}

	public Integer getIsLoss() {
		return isLoss;
	}

	public void setIsLoss(Integer isLoss) {
		this.isLoss = isLoss;
	}

	public Integer getIsRecall() {
		return isRecall;
	}

	public void setIsRecall(Integer isRecall) {
		this.isRecall = isRecall;
	}

	public Integer getHasSystemSendGift() {
		return hasSystemSendGift;
	}

	public void setHasSystemSendGift(Integer hasSystemSendGift) {
		this.hasSystemSendGift = hasSystemSendGift;
	}

	public Integer getHasManualSendGift() {
		return hasManualSendGift;
	}

	public void setHasManualSendGift(Integer hasManualSendGift) {
		this.hasManualSendGift = hasManualSendGift;
	}

	public String getFollowerNumber() {
		return followerNumber;
	}

	public void setFollowerNumber(String followerNumber) {
		this.followerNumber = followerNumber == null ? null
				: followerNumber.trim();
	}

	public String getVisitHistory() {
		return visitHistory;
	}

	public void setVisitHistory(String visitHistory) {
		this.visitHistory = visitHistory == null ? null : visitHistory.trim();
	}

	//	public String getEndGenerateDate() {
	//		return endGenerateDate;
	//	}
	//
	//	public void setEndGenerateDate(String endGenerateDate) {
	//		this.endGenerateDate = endGenerateDate;
	//	}

	public String getStartInterposeDate() {
		return startInterposeDate;
	}

	public void setStartInterposeDate(String startInterposeDate) {
		this.startInterposeDate = startInterposeDate;
	}

	public String getEndInterposeDate() {
		return endInterposeDate;
	}

	public void setEndInterposeDate(String endInterposeDate) {
		this.endInterposeDate = endInterposeDate;
	}

	//	public String getStartGenerateDate() {
	//		return startGenerateDate;
	//	}
	//
	//	public void setStartGenerateDate(String startGenerateDate) {
	//		this.startGenerateDate = startGenerateDate;
	//	}

	public String getEndRecallDate() {
		return endRecallDate;
	}

	public void setEndRecallDate(String endRecallDate) {
		this.endRecallDate = endRecallDate;
	}

	public String getStartRecallDate() {
		return startRecallDate;
	}

	public void setStartRecallDate(String startRecallDate) {
		this.startRecallDate = startRecallDate;
	}

	public Integer getServerid() {
		return serverid;
	}

	public void setServerid(Integer serverid) {
		this.serverid = serverid;
	}

	public String getStartLossDate() {
		return startLossDate;
	}

	public void setStartLossDate(String startLossDate) {
		this.startLossDate = startLossDate;
	}

	public String getEndLossDate() {
		return endLossDate;
	}

	public void setEndLossDate(String endLossDate) {
		this.endLossDate = endLossDate;
	}

	public Integer getLossDays() {
		return lossDays;
	}

	public void setLossDays(Integer lossDays) {
		this.lossDays = lossDays;
	}

	public Integer getStartLossDays() {
		return startLossDays;
	}

	public void setStartLossDays(Integer startLossDays) {
		this.startLossDays = startLossDays;
	}

	public Integer getEndLossDays() {
		return endLossDays;
	}

	public void setEndLossDays(Integer endLossDays) {
		this.endLossDays = endLossDays;
	}

}