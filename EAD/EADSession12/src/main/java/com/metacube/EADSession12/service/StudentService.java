/**
 * 
 */
package com.metacube.EADSession12.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.EADSession12.model.commands.StudentCommands;


/**
 * This interface used to define method for student service 
 * @author Vinod
 *
 */
@Service
public interface StudentService {
	
	public boolean addStudent(StudentCommands student);
	
	public List<StudentCommands> getAll();
	
	public StudentCommands getByEmail(String email);
	
	public boolean isEmailExist(String email);

}
