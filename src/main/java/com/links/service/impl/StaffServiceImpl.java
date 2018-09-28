package com.links.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.links.bean.Staff;
import com.links.dao.IStaffDao;
import com.links.service.IStaffService;

@Service
public class StaffServiceImpl implements IStaffService {
	
	@Autowired
	private IStaffDao staffDao;

	public List<Staff> staffInfoList() {
		List<Staff> list = staffDao.staffList();
		return list;
	}

	public void deleteStaffInfo(String staffJobId) {
		staffDao.deleteStaff(staffJobId);
	}

	public void editStaffInfo(Staff staff) {
		staffDao.editStaff(staff);
	}

	public Staff selectStaffByJobId(String staffJobId) {
		Staff staff = staffDao.selectStaffByJobId(staffJobId);
		return staff;
	}

	public void addStaffInfo(Staff staff) {
		staffDao.inserStaff(staff);
	}
	
}
