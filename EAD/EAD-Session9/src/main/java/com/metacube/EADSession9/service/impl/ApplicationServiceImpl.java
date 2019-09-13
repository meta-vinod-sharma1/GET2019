/**
 * 
 */
package com.metacube.EADSession9.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADSession9.dao.ApplicationDAO;
import com.metacube.EADSession9.mode.commands.EmployeeCommands;
import com.metacube.EADSession9.mode.commands.EmployeeInfo;
import com.metacube.EADSession9.mode.commands.ProfileCommands;
import com.metacube.EADSession9.service.ApplicationService;

/**
 * @author Vinod
 *
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	ApplicationDAO applicationDAO;

	/* 
	 * @see com.metacube.EADSession9.service.ApplicationService#addEmployee(com.metacube.EADSession9.mode.commands.EmployeeCommands)
	 */
	@Override
	public boolean addEmployee(EmployeeCommands emp) {
		return applicationDAO.addEmployee(emp);
	}

	/* 
	 * @see com.metacube.EADSession9.service.ApplicationService#editProfile(com.metacube.EADSession9.mode.commands.EmployeeCommands)
	 */
	@Override
	public boolean editProfile(EmployeeCommands emp) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.metacube.EADSession9.service.ApplicationService#getFriends(java.lang.String)
	 */
	@Override
	public List<String> getFriends(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.metacube.EADSession9.service.ApplicationService#getEmployeeByEmail(java.lang.String)
	 */
	@Override
	public EmployeeCommands getEmployeeByEmail(String email) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.metacube.EADSession9.service.ApplicationService#getProfile(java.lang.String)
	 */
	@Override
	public ProfileCommands getProfile(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeInfo getEmpoyeeInfo(String email) {
		EmployeeInfo info = new EmployeeInfo();
		if(email.equals("vinod.sharma1@metacube.com")){
			info.setEmail(email);
			info.setPassword("Vinod@123");
			info.setEmpId("100");
			info.setVehicleNumber("RJ14uc2030");
			info.setImage("vinod.jpg");
		}else{
			info.setEmail(email);
			info.setPassword("Vinod@123");
			info.setEmpId("101");
			info.setImage("parking.png");
		}
		return info;
	}

}
