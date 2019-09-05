package com.parking.validation;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.parking.database.DatabaseOperation;
import com.parking.pojo.Employee;

public class Validation {
	
	/**
	 * This method used to validate which employee is registring to prevent our database affected
	 * @param empObj object of employee
	 * @return true if valid otherwise false
	 */
	public boolean EmployeeValidation(Employee empObj) {
		boolean flag = true;
		
		String name = empObj.getName();
		String email = empObj.getEmail();
		String password = empObj.getPassword();

		//name Validation
		if(name.length()>150 && name.length()<1){
			flag = false;
		}else if(email.length()>150){
			flag = false;
		}else if(password.length()>17){
			flag = false;
		}
		return flag;
	}
	
	public boolean SessionValidation(HttpServletRequest request){
		boolean flag = false;
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if(email!= null){
			flag = true;
		}
		return flag;
	}
	

}
