package com.links.bean;

public class Staff {
	private int staffId;

	private String staffName;

	private String staffPwd;

	private String staffJobId;

	private Team team;

	public Staff() {
		super();
	}

	public Staff(String staffPwd, String staffJobId) {
		super();
		this.staffPwd = staffPwd;
		this.staffJobId = staffJobId;
	}
	
	public Staff(String staffName, String staffPwd, String staffJobId, Team team) {
		super();
		this.staffName = staffName;
		this.staffPwd = staffPwd;
		this.staffJobId = staffJobId;
		this.team = team;
	}

	public Staff(int staffId, String staffName, String staffPwd, String staffJobId, Team team) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffPwd = staffPwd;
		this.staffJobId = staffJobId;
		this.team = team;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPwd() {
		return staffPwd;
	}

	public void setStaffPwd(String staffPwd) {
		this.staffPwd = staffPwd;
	}

	public String getstaffJobId() {
		return staffJobId;
	}

	public void setstaffJobId(String staffJobId) {
		this.staffJobId = staffJobId;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffPwd=" + staffPwd + ", staffJobId="
				+ staffJobId + ", team=" + team + "]";
	}

}
