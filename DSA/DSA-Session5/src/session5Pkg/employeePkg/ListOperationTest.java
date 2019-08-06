package session5Pkg.employeePkg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListOperationTest {
	
	ListOperation listObj = null;
	@Before
	public void intialize(){
		listObj = new ListOperation();
	}

	@Test
	public void test1() {
		listObj.addElement(new Employee("name1",40000, 21));
		listObj.addElement(new Employee("name2",30000, 21));
		listObj.addElement(new Employee("name3",40001, 21));
		listObj.addElement(new Employee("name4",40001, 20));
		listObj.addElement(new Employee("name5",40008, 21));
		
		
		String [] nameInList = {"name5","name4","name3","name1","name2"};
		listObj.head = listObj.mergeSort(listObj.head);
		
		assertArrayEquals(nameInList, listObj.nameOfEmployeeInList(listObj.head));
	}
	
	@Test
	public void test2() {
		listObj.addElement(new Employee("vinod",10000, 15));
		listObj.addElement(new Employee("mohan",10000, 20));
		listObj.addElement(new Employee("ankita",8000, 20));
		listObj.addElement(new Employee("vijay",2000, 20));
		listObj.addElement(new Employee("ajay",5000, 20));
		
		
		String [] nameInList = {"vinod","mohan","ankita","ajay","vijay"};
		listObj.head = listObj.mergeSort(listObj.head);
		
		assertArrayEquals(nameInList, listObj.nameOfEmployeeInList(listObj.head));
	}

}
