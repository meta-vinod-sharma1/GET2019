package session4Pkg.employeePkg;

import java.util.Comparator;

/**
 * This class used to sort an Employee list as Name
 * @author Vinod
 *
 */
public class sortOnName implements Comparator<Employee>{
	
	public int compare(Employee emp1, Employee emp2){
		return (emp1.getName().compareTo(emp2.getName()));
	}
}
