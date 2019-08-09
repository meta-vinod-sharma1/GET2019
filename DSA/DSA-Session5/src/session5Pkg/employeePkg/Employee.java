package session5Pkg.employeePkg;

/**
 * This class used to create a employee
 * @author Vinod
 * @date 08/05/2019
 */
public class Employee {
	private String name;
	private double salary;
	private int age;
	
	public Employee(String name, double salary , int age){
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	
	/**
	 * This method used to get Name of employee
	 * @return name of employee
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * This method used to get Salary of employee
	 * @return salary of employee
	 */
	public double getSalary(){
		return salary;
	}
	
	/**
	 * This method used to get Age of Employee
	 * @return age of employee
	 */
	public int getAge(){
		return age;
	}

	
}
