/**
 * 
 */
package com.metacube.EADSession13.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADSession13.dao.ApplicationDAO;
import com.metacube.EADSession13.mode.commands.EmployeeCommands;
import com.metacube.EADSession13.mode.commands.EmployeeInfo;
import com.metacube.EADSession13.mode.commands.ProfileCommands;
import com.metacube.EADSession13.service.ApplicationService;

/**
 * This class used to implement all the busniess logic of the application 
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
	public boolean update(EmployeeCommands emp) {
		return applicationDAO.update(emp);
	}

	/* (non-Javadoc)
	 * @see com.metacube.EADSession9.service.ApplicationService#getFriends(java.lang.String)
	 */
	@Override
	public List<String> getFriends(String email) {
		return applicationDAO.getFriends(email);
	}

	/* (non-Javadoc)
	 * @see com.metacube.EADSession9.service.ApplicationService#getEmployeeByEmail(java.lang.String)
	 */
	@Override
	public EmployeeCommands getEmployeeByEmail(String email) {
		return applicationDAO.getEmployee(email);
	}

	/* (non-Javadoc)
	 * @see com.metacube.EADSession9.service.ApplicationService#getProfile(java.lang.String)
	 */
	@Override
	public ProfileCommands getProfile(String email) {
		return applicationDAO.getProfile(email);
	}

	@Override
	public EmployeeInfo getEmpoyeeInfo(String email, String password) {
		EmployeeInfo info = applicationDAO.getEmpoyeeInfo(email, password);
		if(info!=null && info.getImage()==null){
			info.setImage("parking.png");
		}
		return info; 
	}

	@Override
	public boolean uploadPhoto(String email,String imgName, String existImgName){
		if(!existImgName.equals("parking.png")){
			return applicationDAO.updateUploadPhoto(email, imgName);
		}else{
			return applicationDAO.uploadPhoto(email, imgName);
		}
		
	}

	@Override
	public boolean addVehicle(int empId, String name, String type,
			String vehicleNumber, String identification) {
		return applicationDAO.addVehicle(empId,name,type,vehicleNumber,identification);
	}

	@Override
	public boolean addPlan(int empId, String vehicleNumber, String plan,
			double price) {
		return applicationDAO.addPlan(empId,vehicleNumber,plan,price);
	}

}
