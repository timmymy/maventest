package com.links.dao;

import java.util.List;

import com.links.bean.Staff;

public interface IStaffDao {
	
	List<Staff> staffList();

	void deleteStaff(String staffJobId);
	
	void editStaff(Staff staff);

	Staff selectStaffByJobId(String staffJobId);
	
	void inserStaff(Staff staff);
	
}
