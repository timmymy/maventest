package com.links.dao;

import java.util.List;

import com.links.bean.Team;

public interface ITeamDao {
	
	Team teamInfo(int teamId);
	
	void insertTeam(Team team) throws Exception;
	
	List<Team> selectAllTeamInfos() throws Exception;
	
	void updateTeam(Team team) throws Exception;
	
	void delteTeam(int teamId) throws Exception;
	
}
