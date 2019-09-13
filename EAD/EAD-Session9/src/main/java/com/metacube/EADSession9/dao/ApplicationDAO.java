package com.metacube.EADSession9.dao;

import java.util.List;

import com.metacube.EADSession9.mode.commands.EmployeeCommands;
import com.metacube.EADSession9.mode.commands.ProfileCommands;

public interface ApplicationDAO {

	public boolean addEmployee(EmployeeCommands emp);

	public ProfileCommands get(String email);

	public boolean update(EmployeeCommands emp);

	public List<EmployeeCommands> getAll();
	
	public boolean addVehicle(int empId,String name, String type, String vehicleNumber, String identification);
	
	public boolean addPlan(int empId, String vehicleNumber, String plan, double price);
}
