/**
 * 
 */
package com.metacube.EADSession14.model.commands;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * This is model class we will use this class for authentication and in the UserDetails class
 * @author Vinod
 *
 */
@Entity
@Table(name= "userdetails")
public class User {
	
	@Id
	@Column(name="username")
	private String username ;
	
	@Column(name="password")
	private String password ;
	
	@Column(name="role")
	private String role;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
