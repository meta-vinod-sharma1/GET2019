/**
 * 
 */
package com.metacube.EADSession8.service;

import java.util.ArrayList;
import java.util.List;

import com.metacube.EADSession8.model.commands.StudentCommands;

/**
 * This class used to retrive students list 
 * @author Vinod
 *
 */
public class StudentData {
	List<StudentCommands> studentList = new ArrayList<StudentCommands>();
	
	/**
	 * This method used to get all students
	 * @return list of StudentCommands 
	 */
	public List<StudentCommands> getAllStudent(){
		StudentCommands s1 = new StudentCommands(25,"Vinod","sharma","Kailash Chand Sharma","vinod.sharma1@metacube.com","12","16");
		studentList.add(s1);
		StudentCommands s2 = new StudentCommands(26,"Shobhit","Bhata","Vinod kumar","shobhit@metacube.com","11","16");
		studentList.add(s2);
		StudentCommands s3 = new StudentCommands(27,"Yash","sharma","Shobhit Sharma","yash.sharma@metacube.com","12","17");
		studentList.add(s3);
		
		return studentList;
	}
}
