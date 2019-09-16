package com.metacube.EADSession9.dao;

import java.util.List;

import com.metacube.EADSession9.mode.commands.EmployeeCommands;
import com.metacube.EADSession9.mode.commands.EmployeeInfo;
import com.metacube.EADSession9.mode.commands.ProfileCommands;

public interface ApplicationDAO {
	
	/**
	 * This method used to add Employee
	 * @param emp employee object
	 * @return true if added successfully
	 */
	public boolean addEmployee(EmployeeCommands emp);
	
	/**
	 * This method used to get Profile of a Employee by Email
	 * @param email email of the employee
	 * @return
	 */
	public ProfileCommands getProfile(String email);
	
	/**
	 * This method used to update of logged in employee
	 * @param emp
	 * @return
	 */
	public boolean update(EmployeeCommands emp);
	
	/**
	 * This method used to get Employee data of logged in user
	 * @param email
	 * @return
	 */
	public EmployeeCommands getEmployee(String email);
	
	/**
	 * This method used to get Friend list of logged in Employee 
	 * @param email
	 * @return
	 */
	public List<String> getFriends(String email);
	
	/**
	 * This method used to get info of the employee using email and password
	 * @param email
	 * @param password
	 * @return
	 */
	public EmployeeInfo getEmpoyeeInfo(String email,String password);
	
	/**
	 * This method used to upload Photo of the Employee which don't have photo already in the database
	 * @param email
	 * @param imgName
	 * @return
	 */
	public boolean uploadPhoto(String email, String imgName);
	
	/**
	 * This method used to add Vehicle
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
	
	/**
	 * This method used to update profile picture of the employee
	 * @param email
	 * @param imgName
	 * @return
	 */
	public boolean updateUploadPhoto(String email,String imgName);
}
