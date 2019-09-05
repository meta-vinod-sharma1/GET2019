package com.parking.pojo;

public class Employee {
	
	private String name;
	private String gender;
	private String email;
	private String password;
	private long phoneNumber;
	private int empId;
	private String organization;

	public Employee(String name, String gender, String email, String password, long phoneNumber, String organization,int empId){
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.organization = organization;
		this.empId = empId;
	}
	
	/**
	 * This method used to get name of employee
	 * @return name of employee
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * This method used to get gender of employee
	 * @return gender of employee
	 */
	public String getGender(){
		return gender;
	}
	
	/**
	 * This method used to get email address of employee
	 * @return email of employee
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * This method used to get Password of Employee
	 * @return password of Employee
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * This method used to get phone number of employee
	 * @return
	 */
	public long getPhoneNumber(){
		return phoneNumber;
	}
	
	/**
	 * This method used to get employee id of employee
	 * @return
	 */
	public int getEmployeeId(){
		return empId;
	}
	
	public String getOrganization(){
		return organization;
	}

}
