package session5Pkg.employeePkg;

import java.util.ArrayList;


public class ListOperation{
	
	public Node head = null;
	/**
	 * This method used to add a Employee in the list
	 * @param Employee Object which to be added in the list
	 */
	public void addElement(Employee data){
		Node node = new Node(data);
		if(head == null){
			head = node;
		}else{
			Node tempHead = head;
			while(tempHead.next != null){
				tempHead = tempHead.next;
			}
			tempHead.next = node;
		}
	}
	
	
	/**
	 * This method used to display list 
	 */
	public void DisplayList(){
		
		if(head == null){
			throw new AssertionError("List is Empty");
		}else{
			Node tempHead = head;
			System.out.println("         Name  |    Salary  |     Age");
			System.out.println("---------------+------------+--------------------------------------------------------------");
			while(tempHead != null){
				System.out.format("%14s%3s%10.2f%3s%5d", tempHead.dataObj.getName()," | " ,tempHead.dataObj.getSalary()," | ",tempHead.dataObj.getAge());
				System.out.println("\n---------------+------------+--------------------------------------------------------------");
				tempHead = tempHead.next; 
			}
		
		}
	}
	
	/**
	 * This method used to sort list of employee 
	 * @param head head reference of list
	 * @return Sorted list head
	 */
	public Node mergeSort(Node head) 
	{ 
		// Base case : if head is null or there is only one element in the linked list
		if (head == null || head.next == null) { 
			return head; 
		} 

		// get the middle of the list 
		Node middle = getMiddle(head); 
		Node nextofmiddle = middle.next; 

		// set the next of middle node to null 
		middle.next = null; 

		// Apply mergeSort on left list 
		Node left = mergeSort(head); 

		// Apply mergeSort on right list 
		Node right = mergeSort(nextofmiddle); 

		// Merge the left and right lists 
		Node resultHead = sortedMerge(left, right); 
		return resultHead; 
	} 
	
	/**
	 * This method used to use merge left and right list according Salary and age. this method call from meregeSort() method
	 * @param node1 left list
	 * @param node2 right list
	 * @return merge list
	 */
	private Node sortedMerge(Node node1, Node node2 ){ 
		Node sortedList = null; 
		/* Base cases */
		if (node1 == null) 
			return node2; 
		if (node2 == null) 
			return node1; 

		/* Pick either a or b, and recur */
		if (node1.dataObj.getSalary() > node2.dataObj.getSalary()) { 
			sortedList = node1; 
			sortedList.next = sortedMerge(node1.next, node2); 
		}else if(node1.dataObj.getSalary() == node2.dataObj.getSalary()){ //if the salaries are Equal
			if(node1.dataObj.getAge() < node2.dataObj.getAge()){
				sortedList = node1; 
				sortedList.next = sortedMerge(node1.next, node2); 
			}else{
				sortedList = node2; 
				sortedList.next = sortedMerge(node1, node2.next); 
			}
		}else{ 
			sortedList = node2; 
			sortedList.next = sortedMerge(node1, node2.next); 
		} 
		return sortedList; 
	} 

	

	/**
	 * This method used to get the middle node of the list
	 * @param head
	 * @return
	 */
	private Node getMiddle(Node head){ 
		// Base case 
		if(head == null){
			return head;
		}
		Node fastTracker = head.next; 
		Node slowTracker = head; 

		// Move fastTracker by two and slow Tracker by one  
		while(fastTracker != null){ 
			fastTracker = fastTracker.next; 
			if(fastTracker != null){ 
				slowTracker = slowTracker.next;
				fastTracker = fastTracker.next; 
			} 
		} 
		return slowTracker; 
	} 
	
	/**
	 * This method used to know no of nodes in the list
	 * @return no of nodes in the list
	 */
	public int noOfElementInList(){
		int count = 0;
		Node tempHead = head;
		while(tempHead != null){
			count++;
			tempHead = tempHead.next;
		}
		return count;
	}
	
	/**
	 * This method used to get name list of employees which in the list
	 * @return Array list of employee name
	 */
	public String[] nameOfEmployeeInList(Node head){
		System.out.println(noOfElementInList());
		String[] employeeNameList = new String[noOfElementInList()]; 
		Node tempHead = head;
		for(int i=0; i<noOfElementInList(); i++){
			employeeNameList[i] = tempHead.dataObj.getName();
			tempHead = tempHead.next;
		}
				
		return employeeNameList;
	}
}
