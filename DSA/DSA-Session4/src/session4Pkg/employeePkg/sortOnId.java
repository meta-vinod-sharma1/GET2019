package session4Pkg.employeePkg;

import java.util.Comparator;

/**
 * This class used to sort an Employee list as id
 * @author Vinod
 *
 */
public class sortOnId implements Comparator<Employee> {
	
	public int compare(Employee emp1, Employee emp2){
		return (emp1.getId() > emp2.getId() ? 1 : -1);		
	}
}
