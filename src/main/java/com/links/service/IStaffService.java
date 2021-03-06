package com.links.service;

import java.util.List;

import com.links.bean.Staff;

public interface IStaffService {

	List<Staff> staffInfoList();
	
	void deleteStaffInfo(String staffJobId);
	
	void editStaffInfo(Staff staff);
	
	Staff selectStaffByJobId(String staffJobId);
	
	void addStaffInfo(Staff staff);
	
	Staff login(Staff staff);

	void register(Staff staff);
	
	Staff searchTest(String staffJobId) throws Exception;
}
