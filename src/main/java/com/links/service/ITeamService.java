package com.links.service;

import java.util.List;

import com.links.bean.Team;

public interface ITeamService {
	
	Team teamInfo(int teamId);
	
	void addTeamInfo(Team team) throws Exception;
	
	List<Team> selectAll() throws Exception;
	
	void delteTeam(int teamId) throws Exception;
	
	void editTeamIfo(Team team) throws Exception;
	
}
