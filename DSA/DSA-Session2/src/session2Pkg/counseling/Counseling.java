package session2Pkg.counseling;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;

public class Counseling {
	
	/**
	 * This method used to allocate branch to students according their rank or preference
	 * @param studentQueue Queue list of Students in rank order
	 * @param programList Program offered by college Map with capacity
	 * @return allocating list of AllocateProgram objects
	 */
	public ArrayList<AllocateProgram> allocationProgram(Queue<Student> studentQueue, Map<String,Integer> programList){
		
		ArrayList<AllocateProgram> allocatingList = new ArrayList<AllocateProgram>();
		
		while(studentQueue.size() > 0){
			Student student = studentQueue.peek();
			String studentName = student.getName();
			
			for(int i=0; i<student.getPreferenceList().size(); i++){
				String studentPreference = student.getPreferenceList().get(i);
				
				if(programList.get(studentPreference) > 0){
					AllocateProgram allocateObj = new AllocateProgram(studentName,studentPreference);
					allocatingList.add(allocateObj);
					programList.put(studentPreference, programList.get(studentPreference)-1);
					break;
				}
			}
			studentQueue.remove();
		}
		
		return allocatingList;
	}
}
