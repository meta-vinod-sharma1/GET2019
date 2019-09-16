/**
 * 
 */
package com.metacube.EADSession9.mode.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;





/**
 * This is Entity class for Employee
 * @author Vinod
 *
 */
public class EmployeeCommands {
	
	private int empId;
	@Pattern(regexp="^[a-zA-Z ]{0,50}",message="Name should be alphabetical")
	@Size(min = 2, max =  50,message = "{name}")
	private String name;
	
	@NotBlank
	private String gender;
	
	@Email
	@Pattern(regexp="\\S+@\\S+\\.\\S{0,100}",message="Invalid Email Address")
	private String email;
	
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}",message="{passwordPattern}")
	@Size(min = 8, max =  16,message = "{password}")
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	
	@Size(min = 8, max =  12,message = "{phoneNumber}")
	private String phoneNumber;
	@NotBlank
	private String organization;
	
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	@Override
	public String toString() {
		return "EmployeeCommands [empId=" + empId + ", name=" + name
				+ ", gender=" + gender + ", email=" + email + ", password="
				+ password + ", confirmPassword=" + confirmPassword
				+ ", phoneNumber=" + phoneNumber + ", organization="
				+ organization + "]";
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	
	
}