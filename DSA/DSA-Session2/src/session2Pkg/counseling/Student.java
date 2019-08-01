package session2Pkg.counseling;

import java.util.ArrayList;

/**
 * This class used to create a student 
 * @author Vinod
 *
 */
public class Student {
	private String name;
	private ArrayList<String> preferenceList = null;
	
	public Student(String name, ArrayList<String> preferenceList){
		this.name = name;
		this.preferenceList = preferenceList;
	}
	
	/**
	 * This method used to get a name of student
	 * @return student name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method used get branch preference of student as array list
	 * @return
	 */
	public ArrayList<String> getPreferenceList(){
		return preferenceList;
	}

}
