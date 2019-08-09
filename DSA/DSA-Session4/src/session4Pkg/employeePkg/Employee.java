package session4Pkg.employeePkg;

/**
 * This class used to create a employee
 * @author Vinod
 *
 */
public class Employee {
	private int id;
	private String name;
	private String address;
	
	/**
	 * constructor method for employee
	 * @param id
	 * @param empName
	 * @param address
	 */
	public Employee(int id, String empName, String address) {
		this.id = id;
		this.name = empName;
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public String getAddress(){
		return address;
	}
	public int getId(){
		return id;
	}
	
	
	
}
