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
			throw new TeamException("系统内没有小组信息，请先进行添加小组信息！");
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
			throw new TeamException("组编号不允许重复，请重新设定组编号！");
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
			throw new Exception("对不起，小组信息不存在。");
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
			throw new Exception("对不起，小组信息不存在。");
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
