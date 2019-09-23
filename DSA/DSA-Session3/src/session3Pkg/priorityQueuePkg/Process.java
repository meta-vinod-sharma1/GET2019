package session3Pkg.priorityQueuePkg;

/**
 * This class used to make a process which contain name and priority value
 * @author Vinod
 *
 */
public class Process {
	
	private String name;
	private int priorityValue;

	public Process(String name, int priorityValue){
		this.name = name;
		this.priorityValue = priorityValue;
	}

	/**
	 * This method used to get Priority value of Process
	 * @return the priorityValue
	 */
	public int getPriorityValue(){
		return priorityValue;
	}
	
	/**
	 * This method used to get name of Process
	 * @return name of process
	 */
	public String getName(){
		return name;
	}

	
	
}
