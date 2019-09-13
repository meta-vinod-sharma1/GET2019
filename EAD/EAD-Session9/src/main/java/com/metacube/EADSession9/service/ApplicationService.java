/**
 * 
 */
package com.metacube.EADSession9.service;

import java.util.List;

import com.metacube.EADSession9.mode.commands.EmployeeCommands;
import com.metacube.EADSession9.mode.commands.EmployeeInfo;
import com.metacube.EADSession9.mode.commands.ProfileCommands;

/**
 * @author Vinod
 *
 */
public interface ApplicationService {
	
	public boolean addEmployee(EmployeeCommands emp);
	
	
	public boolean editProfile(EmployeeCommands emp);
	
	public List<String> getFriends(String email);
	
	public EmployeeCommands getEmployeeByEmail(String email);
	
	public ProfileCommands getProfile(String email);
	
	public EmployeeInfo getEmpoyeeInfo(String email);
}
