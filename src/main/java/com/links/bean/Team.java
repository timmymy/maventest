package com.links.bean;

public class Team {
	private int teamId;

	private String groupName;

	private String projectName;

	public Team() {
		super();
	}

	public Team(int teamId, String groupName, String projectName) {
		super();
		this.teamId = teamId;
		this.groupName = groupName;
		this.projectName = projectName;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", groupName=" + groupName + ", projectName=" + projectName + "]";
	}

}
