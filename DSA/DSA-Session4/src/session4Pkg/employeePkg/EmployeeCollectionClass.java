package session4Pkg.employeePkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
/**
 * This class have collection of employees in the List
 * @author Vinod
 *
 */
public class EmployeeCollectionClass {
	//Collections of employees
	List<Employee> empCollection= new ArrayList<Employee>();

	/**
	 * This method used to add an employee
	 * @param emp
	 */
	public void addEmployee(Employee emp){
		
			empCollection.add(emp);
	
	}
	
	/**
	 * This Method used to Sort Employee list by Id
	 */
	public void sortedById(){
		Collections.sort(empCollection , new sortOnId());
		view();
	}
	
	/**
	 * This method used to sort employee list by Name
	 */
	void sortedByName(){
		
		Collections.sort(empCollection,new sortOnName());
		view();
		
	}
	/**
	 * This method used to view Employee List
	 */
	private void view(){
		System.out.println("  Id  |     Name   |     Address");
		System.out.println("------+------------+--------------------------------------------------------------");
		for(Employee Iterator :empCollection){
			System.out.format("%5d%3s%10s%3s%20s", Iterator.getId()," | " ,Iterator.getName()," | ",Iterator.getAddress());
			System.out.println("\n------+------------+--------------------------------------------------------------");
		}
		
	}
	
	
	
	
}
