/**
 * 
 */
package com.metacube.EADSession11.dao;

import java.util.List;

import com.metacube.EADSession11.model.commands.StudentCommands;

/**
 * This interface used for persistence layer of student 
 * @author Vinod
 *
 */
public interface StudentDao {
	
	public void addStudent(StudentCommands student);
	
	public List<StudentCommands> getAll();
	
	public List<StudentCommands> getByEmail(StudentCommands student);
}
