package com.links.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.links.bean.Team;
import com.links.exception.TeamException;
import com.links.service.ITeamService;

@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Resource
	private ITeamService teamService;
	
	@RequestMapping("/addDo")
	public ModelAndView addDoTeam() {
		ModelAndView mv = new ModelAndView("addTeam");
		return mv;
	}
	
	@RequestMapping("/all")
	public ModelAndView teamList() throws Exception {
		List<Team> list = teamService.selectAll();
		if (list == null) {
			throw new TeamException("ϵͳ��û��С����Ϣ�����Ƚ������С����Ϣ��");
		}
		ModelAndView mv = new ModelAndView("teamList");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView addTeamInfo(@RequestParam(value="tid") String teamId,@RequestParam(value="groupName") String teamGroupName,
			@RequestParam(value="projectName") String teamProjectName) throws Exception {
		Team teamInfo = teamService.teamInfo(Integer.parseInt(teamId));
		if(teamInfo != null) {
			throw new TeamException("���Ų������ظ����������趨���ţ�");
		}
		Team team = new Team(Integer.parseInt(teamId),teamGroupName,teamProjectName);
		teamService.addTeamInfo(team);
		List<Team> list = teamService.selectAll();
		ModelAndView mv = new ModelAndView("teamList");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteTeam(@RequestParam(value="id") String teamId) throws Exception {
		Team team = teamService.teamInfo(Integer.parseInt(teamId));
		if (team == null) {
			throw new Exception("�Բ���С����Ϣ�����ڡ�");
		}
		teamService.delteTeam(Integer.parseInt(teamId));
		ModelAndView mv = new ModelAndView("teamList");
		List<Team> list = teamService.selectAll();
		mv.addObject("list", list);
		mv.addObject("msg", "delete ok");
		return mv;
	}
	
	@RequestMapping("/editDo")
	public ModelAndView editDoTeam(@RequestParam(value="id") String teamId) throws Exception {
		Team team = teamService.teamInfo(Integer.parseInt(teamId));
		if (team == null) {
			throw new Exception("�Բ���С����Ϣ�����ڡ�");
		}
		ModelAndView mv = new ModelAndView("editTeam");
		mv.addObject("teamInfo", team);
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editTeam(@RequestParam(value="teamId") String teamId ,@RequestParam(value="groupName") String groupName ,
			@RequestParam(value="projectName") String projectName) throws Exception {
		Team team = new Team(Integer.parseInt(teamId),groupName,projectName);
		teamService.editTeamIfo(team);
		ModelAndView mv = new ModelAndView("teamList");
		List<Team> list = teamService.selectAll();
		mv.addObject("list", list);
		mv.addObject("msg", "edit ok");
		return mv;
	}
	
}
