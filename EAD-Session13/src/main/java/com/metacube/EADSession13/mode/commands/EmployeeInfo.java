/**
 * 
 */
package com.metacube.EADSession13.mode.commands;

/**
 * This is entity class for employee info
 * @author Vinod
 *
 */
public class EmployeeInfo {
	
	@Override
	public String toString() {
		return "EmployeeInfo [email=" + email + ", password=" + password
				+ ", empId=" + empId + ", vehicleNumber=" + vehicleNumber
				+ ", image=" + image + "]";
	}
	private String email;
	private String password;
	private String empId;
	private String vehicleNumber;
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
}
