package listPkg;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubListOperationTest {
	
	List listObj = null;
	SubListOperation operationObj = new SubListOperation();
	@Test
	public void testRotateSubList() {
		listObj = new List();
		listObj.addElement(1);
		listObj.addElement(2);
		listObj.addElement(3);
		listObj.addElement(4);
		listObj.addElement(5);
		listObj.addElement(6);
		listObj.addElement(7);
		
		int arr[] = {1,3,4,5,2,6,7};
		operationObj.rotateSubList(2,5, 3, listObj);  //3 times rotate
		assertArrayEquals(arr, listObj.convertListToArray(listObj));
		
		// now list is 1 3 4 5 2 6 7 
		int arr1[] = {2,1,3,4,5,6,7};
		operationObj.rotateSubList(1,5, 1, listObj); // 1 times rotate
		assertArrayEquals(arr1, listObj.convertListToArray(listObj));
		
		//now list is 2 1 3 4 5 6 7
		int arr2[] = {5,6,7,2,1,3,4};
		operationObj.rotateSubList(1,7, 10, listObj); // 10 times rotate
		assertArrayEquals(arr2, listObj.convertListToArray(listObj));
		
		//now list is 5 6 7 2 1 3 4
		int arr3[] = {4,3,5,6,7,2,1};
		operationObj.rotateSubList(1,7, 2, listObj); // 2 times rotate
		assertArrayEquals(arr3, listObj.convertListToArray(listObj));
		
		//operationObj.rotateSubList(1,8, 2, listObj);  
	//Assertion Error can't go outside	assertArrayEquals(arr2, listObj.convertListToArray(listObj));
		
		//operationObj.rotateSubList(6,5, 2, listObj); 
	//Assertion Error 	assertArrayEquals(arr2, listObj.convertListToArray(listObj));
		
	}
	
}
