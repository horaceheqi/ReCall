package com.cyou.bi.ms.ds.recall.bean;

public class AccountsData {
	private String cnmaster;
	private String roleName;
	private Integer roleLevel;
	private Integer roleGroupid;
	private String equipscore;
	private String xfscore;
	private String xlscore;
    private String bsscore;
    private Integer logonFlag;
	private String cnGuid;
	private String dt;

	public String getCnmaster() {
		return cnmaster;
	}

	public void setCnmaster(String cnmaster) {
		this.cnmaster = cnmaster == null ? null : cnmaster.trim();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public Integer getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}

	public Integer getRoleGroupid() {
		return roleGroupid;
	}

	public void setRoleGroupid(Integer roleGroupid) {
		this.roleGroupid = roleGroupid;
	}

	public String getCnGuid() {
		return cnGuid;
	}

	public void setCnGuid(String cnGuid) {
		this.cnGuid = cnGuid == null ? null : cnGuid.trim();
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public void setXfscore(String xfscore) {
		this.xfscore = xfscore;
	}

	public String getXfscore() {
		return xfscore;
	}

	public void setXlscore(String xlscore) {
		this.xlscore = xlscore;
	}

	public String getXlscore() {
		return xlscore;
	}

	public void setBsscore(String bsscore) {
		this.bsscore = bsscore;
	}

	public String getBsscore() {
		return bsscore;
	}

	public Integer getLogonFlag() {
		return logonFlag;
	}

	public void setLogonFlag(Integer logonFlag) {
		this.logonFlag = logonFlag;
	}

	public void setEquipscore(String equipscore) {
		this.equipscore = equipscore;
	}

	public String getEquipscore() {
		return equipscore;
	}
}