package com.links.service.impl;

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

}
