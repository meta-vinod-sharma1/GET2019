/**
 * 
 */
package com.metacube.EADSession14.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.EADSession14.model.commands.StudentCommands;
import com.metacube.EADSession14.model.commands.User;


/**
 * This interface used to define method for student service 
 * @author Vinod
 *
 */
public interface StudentService {
	
	/**
	 * This method used to add a new Student in the database 
	 * @param student object of StudentCommands 
	 * @return true if student is added
	 */
	public boolean addStudent(StudentCommands student);
	
	/**
	 * This method used to get all the student from database
	 * @return list of object of StudentCommands
	 */
	public List<StudentCommands> getAll();
	
	/**
	 * This method used to get a single StudentCommadns object
	 * @param email 
	 * @return object of Student Commands 
	 */
	public StudentCommands getByEmail(String email);
	
	/**
	 * This method used to check that email is already exist or not in the database
	 * @param email
	 * @return true if exist otherwise false
	 */
	public boolean isEmailExist(String email);
	
	public User findUserByName(String username);

}
