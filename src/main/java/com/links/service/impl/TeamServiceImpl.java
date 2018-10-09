package com.links.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.links.bean.Team;
import com.links.dao.ITeamDao;
import com.links.service.ITeamService;

@Service
public class TeamServiceImpl implements ITeamService {
	
	@Autowired
	private ITeamDao teamDao;
	
	public Team teamInfo(int teamId) {
		return teamDao.teamInfo(teamId);
	}

	public void addTeamInfo(Team team) throws Exception {
		teamDao.insertTeam(team);
	}

	public List<Team> selectAll() throws Exception {
		List<Team> list = teamDao.selectAllTeamInfos();
		return list;
	}

	public void delteTeam(int teamId) throws Exception {
		teamDao.delteTeam(teamId);
	}

	public void editTeamIfo(Team team) throws Exception {
		teamDao.updateTeam(team);
	}

}
