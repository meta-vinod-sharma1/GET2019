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
	
	/**
	 * This method used to add an Employee in the database
	 * @param emp Employee Object of EmployeeCommands Class
	 * @return true if added
	 */
	public boolean addEmployee(EmployeeCommands emp);
	
	/**
	 * This method used to edit Profile of the Employee
	 * @param emp EmployeeCommands object
	 * @return
	 */
	public boolean update(EmployeeCommands emp);
	
	/**
	 * this method used to get Employee list of which is match with our organization
	 * @param email email of the Employee 
	 * @return list of String of email's 
	 */
	public List<String> getFriends(String email);
	
	/**
	 * This methoud used to get Employee object by Email
	 * @param email
	 * @return
	 */
	public EmployeeCommands getEmployeeByEmail(String email);
	
	/**
	 * This method used to get profile of the Employee
	 * @param email
	 * @return
	 */
	public ProfileCommands getProfile(String email);
	
	/**
	 * This method used to get Employee Info 
	 * @param email
	 * @param password
	 * @return
	 */
	public EmployeeInfo getEmpoyeeInfo(String email,String password);
	
	/**
	 * This method used to set profile picture of the User 
	 * @param email
	 * @param imgName
	 * @param existImgName
	 * @return
	 */
	public boolean uploadPhoto(String email,String imgName, String existImgName);
	
	/**
	 * This method used to add vehicle
	 * @param empId
	 * @param name
	 * @param type
	 * @param vehicleNumber
	 * @param identification
	 * @return
	 */
	public boolean addVehicle(int empId,String name, String type, String vehicleNumber, String identification);
	
	/**
	 * This method used to add plan of the pass 
	 * @param empId
	 * @param vehicleNumber
	 * @param plan
	 * @param price
	 * @return
	 */
	public boolean addPlan(int empId, String vehicleNumber, String plan, double price);
}
