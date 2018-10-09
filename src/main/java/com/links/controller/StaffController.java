package com.links.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.links.bean.Staff;
import com.links.bean.Team;
import com.links.exception.StaffException;
import com.links.service.IStaffService;
import com.links.service.ITeamService;

@Controller
@RequestMapping("/staff" )
public class StaffController {
	
	@Resource
	private IStaffService staffService;
	@Resource
	private ITeamService teamService;
	
	@RequestMapping("/show" )
	public ModelAndView showStaffList() {
		ModelAndView mv = new ModelAndView("showList");
		List<Staff> list = staffService.staffInfoList();
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delStaff(@RequestParam(value = "id") String staffJobId) {
		staffService.deleteStaffInfo(staffJobId);
		List<Staff> list = staffService.staffInfoList();
		ModelAndView mv = new ModelAndView("showList");
		mv.addObject("list", list);
		mv.addObject("msg","delete ok");
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editStaffInfo(@RequestParam(value = "staffJobId") String staffJobId,@RequestParam(value = "staffName") String staffName,
			@RequestParam(value = "staffPwd") String staffPwd,@RequestParam(value = "teamId") String teamId
			) {
		Team team = teamService.teamInfo(Integer.parseInt(teamId));
		Staff staff = new Staff(staffName,staffPwd,staffJobId,team);
		staffService.editStaffInfo(staff);
		List<Staff> list = staffService.staffInfoList();
		ModelAndView mv = new ModelAndView("showList");
		mv.addObject("msg","edit ok");
		mv.addObject("list", list);
		return mv;
	} 
	
	@RequestMapping("/editDo")
	public ModelAndView editStaffDo(@RequestParam(value = "id") String staffJobId) {
		Staff staff = staffService.selectStaffByJobId(staffJobId);
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("staffInfo",staff);
		return mv;
	}
	
	@RequestMapping("/addDo")
	public ModelAndView addStaffDo() {
		ModelAndView mv = new ModelAndView("addStaff");
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView addStaff(@RequestParam(value = "staffJobId") String staffJobId,@RequestParam(value = "staffName") String staffName,
			@RequestParam(value = "staffPwd") String staffPwd,@RequestParam(value = "teamId") String teamId
			) {
		Team team = teamService.teamInfo(Integer.parseInt(teamId));
		Staff staff = new Staff(staffName,staffPwd,staffJobId,team);
		staffService.addStaffInfo(staff);
		ModelAndView mv = new ModelAndView("showList");
		List<Staff> list = staffService.staffInfoList();
		mv.addObject("msg","add ok");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/loginDo")
	public ModelAndView loginDo() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "act") String staffJobId,@RequestParam(value = "pwd") String staffPwd,
			HttpSession session) {
		Staff staff = staffService.selectStaffByJobId(staffJobId);
		//Staff logStaff = staffService.login(staff);
		ModelAndView mv = null;
		if (staffPwd.equals(staff.getStaffPwd())) {
			session.setAttribute("staffInfo", staff);
			
			mv = new ModelAndView("welcome");
			//mv.addObject("staff", staff);
			mv.addObject("msg", "login ok");
		}else {
			mv = new ModelAndView("login");
			mv.addObject("msg", "act or pwd is error");
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(
			/*@RequestParam(value="uid") String staffJobId,*/
			HttpSession session) {
		//Staff staff = staffService.selectStaffByJobId(staffJobId);
		//session.removeValue(staff);
		ModelAndView mv = new ModelAndView("welcome");
		session.removeAttribute("staffInfo");
		return mv;
	}
	
	@RequestMapping("/registerDo")
	public ModelAndView registerDo() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(@RequestParam(value = "staffJobId") String staffJobId,@RequestParam(value = "staffName") String staffName,
			@RequestParam(value = "staffPwd") String staffPwd,@RequestParam(value = "teamId") String teamId
			) {
		Team team = teamService.teamInfo(Integer.parseInt(teamId));
		Staff staff = new Staff(staffName,staffPwd,staffJobId,team);
		staffService.addStaffInfo(staff);
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("msg","register ok");
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView searchStaff(@RequestParam(value = "searchId") String staffJobId) throws Exception {
		Staff staff = staffService.searchTest(staffJobId);
		if (staff==null) {
			throw new StaffException("查无此人，请确认员工号");
		}
		ModelAndView mv = new ModelAndView("showList");
		List<Staff> list = new ArrayList<Staff>();
		list.add(staff);
		mv.addObject("list", list);
		return mv;
	}
	
	
}
